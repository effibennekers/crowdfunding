package nl.ing.crowdfunding.service;

import nl.ing.crowdfunding.dao.InvesteringRepository;
import nl.ing.crowdfunding.dao.KlantRepository;
import nl.ing.crowdfunding.dao.ProjectRepository;
import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.domain.Klant;
import nl.ing.crowdfunding.domain.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ProjectService {

    @Resource
    private ProjectRepository projectRepository = new ProjectRepository();

    @Resource
    private KlantRepository klantRepository = new KlantRepository();

    @Resource
    private InvesteringRepository investeringRepository = new InvesteringRepository();

    public List<Project> getAll() {
        List<Project> all = projectRepository.getAll();
        for (Project project : all) {
            enrich(project);
        }
        return all;
    }

    public Project getById(String id) {
        Project project = projectRepository.find(id);
        enrich(project);
        return project;
    }

    public List<Project> getByKlantId(String klantId) {
        return projectRepository.findByKlant(klantId);
    }

    public void deleteById(String id) {
        projectRepository.delete(id);
    }

    private void enrich(Project project) {
        enrichNaam(project);
        enrichBereiktBedrag(project);
    }

    private void enrichBereiktBedrag(Project project) {
        BigDecimal bereiktBedrag = new BigDecimal(0);
        List<Investering> investeringen = investeringRepository.findByProject(String.valueOf(project.getProjectid()));
        for (Investering investering : investeringen) {
            bereiktBedrag = bereiktBedrag.add(investering.getBedrag());
        }
        project.setBereiktBedrag(bereiktBedrag.toString());
    }

    private void enrichNaam(Project project) {
        Klant klant = klantRepository.find(String.valueOf(project.getEigenaar()));
        StringBuffer naamBuf = new StringBuffer();
        naamBuf.append(klant.getVoornaam());
        if (org.springframework.util.StringUtils.hasText(klant.getTussenvoegsels())) {
            naamBuf.append(" ");
            naamBuf.append(klant.getTussenvoegsels());
        }
        naamBuf.append(" ");
        naamBuf.append(klant.getAchternaam());

        project.setNaam(naamBuf.toString());
    }

    public void save(Project project) {
        if (project.isNieuw()) {
            vulRisico(project);
        }
        projectRepository.save(project);
    }

    private void vulRisico(Project project) {
        vulEigenaarsRisico(project);
        vulProjectRisico(project);
    }

    private void vulEigenaarsRisico(Project project) {
        int eigenaarsRisicoProfiel = 5;
        Klant klant = klantRepository.find(String.valueOf(project.getEigenaar()));
        if (klant.isIngKlant()) {
            eigenaarsRisicoProfiel--;
        }
        Date date1970 = null;
        try {
            date1970 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse("January 1, 1970");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (klant.getGeboortedag().before(date1970)) {
            eigenaarsRisicoProfiel--;
        }
        project.setEigenaarrisicoprofiel(eigenaarsRisicoProfiel);
    }

    private void vulProjectRisico(Project project) {
        int projectsRisicoProfiel = 5;
        Klant klant = klantRepository.find(String.valueOf(project.getEigenaar()));
        if (project.getDoelbedrag().compareTo(new BigDecimal(1000)) < 0) {
            projectsRisicoProfiel--;
        }
        if (project.getRentepercentage().compareTo(new BigDecimal(5)) < 0) {
            projectsRisicoProfiel--;
        }
        project.setRisicoprofiel(projectsRisicoProfiel);
    }

}
