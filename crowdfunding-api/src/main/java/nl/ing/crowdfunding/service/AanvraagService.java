package nl.ing.crowdfunding.service;

import nl.ing.crowdfunding.dao.AanvraagRepository;
import nl.ing.crowdfunding.domain.Aanvraag;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AanvraagService {

	@Resource
	private AanvraagRepository aanvraagRepository;

    public List<Aanvraag> getAllAanvragen() {
        return null;
    }

	public Aanvraag getAanvraag(String id) {
		return aanvraagRepository.find(id);
	}

	public void deleteAanvraag(String id) {
        aanvraagRepository.delete(id);
	}

    public void saveAanvraag(Aanvraag aanvraag) {
        aanvraagRepository.save(aanvraag);
    }

}
