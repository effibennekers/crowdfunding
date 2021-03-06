package nl.ing.crowdfunding.service;

import nl.ing.crowdfunding.dao.KlantRepository;
import nl.ing.crowdfunding.domain.Klant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KlantService {

    @Resource
    private KlantRepository klantRepository = new KlantRepository();

    public List<Klant> getAll() {
        return klantRepository.getAll();
    }

    public Klant getById(String id) {
        return klantRepository.find(id);
    }

    public Klant getByEmail(String email, String password) {
        return klantRepository.find(email, password);
    }

    public void deleteById(String id) {
        klantRepository.delete(id);
    }

    public void save(Klant klant) {
        klantRepository.save(klant);
    }

}
