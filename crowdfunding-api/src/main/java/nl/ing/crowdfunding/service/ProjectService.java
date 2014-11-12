package nl.ing.crowdfunding.service;

import nl.ing.crowdfunding.dao.ProjectRepository;
import nl.ing.crowdfunding.domain.Klant;
import nl.ing.crowdfunding.domain.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectService {

	@Resource
	private ProjectRepository projectRepository = new ProjectRepository();

    public List<Project> getAll() {
        return null;
    }

	public Project getById(String id) {
		return projectRepository.find(id);
	}

	public void deleteById(String id) {
        projectRepository.delete(id);
	}

    public void save(Project project) {
        projectRepository.save(project);
    }

}
