package nl.ing.crowdfunding.dao;

import nl.ing.crowdfunding.domain.Afbetaling;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class AfbetalingRepository {

    public Afbetaling find(String id) {
        Afbetaling afbetaling = new Afbetaling();
        afbetaling.setDatumtijd(new Date());
        return afbetaling;
    }

    public void save(Afbetaling afbetaling) {
        //TODO
    }

    public void delete(String id) {
        //TODO
    }

}
