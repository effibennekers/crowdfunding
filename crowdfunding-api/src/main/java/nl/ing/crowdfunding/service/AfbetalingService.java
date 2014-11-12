package nl.ing.crowdfunding.service;

import nl.ing.crowdfunding.dao.AfbetalingRepository;
import nl.ing.crowdfunding.domain.Afbetaling;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AfbetalingService {

	@Resource
	private AfbetalingRepository afbetalingRepository;

    public List<Afbetaling> getAll() {
        return null;
    }

	public Afbetaling getById(String id) {
		return afbetalingRepository.find(id);
	}

	public void deleteById(String id) {
        afbetalingRepository.delete(id);
	}

    public void save(Afbetaling afbetaling) {
        afbetalingRepository.save(afbetaling);
    }

}
