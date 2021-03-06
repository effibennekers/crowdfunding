package nl.ing.crowdfunding.service;

import nl.ing.crowdfunding.dao.InvesteringRepository;
import nl.ing.crowdfunding.domain.Investering;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InvesteringService {

    @Resource
    private InvesteringRepository investeringRepository = new InvesteringRepository();

    public List<Investering> getAll() {
        return investeringRepository.getAll();
    }

    public Investering getById(String id) {
        return investeringRepository.find(id);
    }

    public List<Investering> getByProjectId(String projectId) {
        return investeringRepository.findByProject(projectId);
    }

    public void deleteById(String id) {
        investeringRepository.delete(id);
    }

    public void save(Investering investering) {
        investeringRepository.save(investering);
    }

}
