package nl.ing.crowdfunding.engine;

import nl.ing.crowdfunding.domain.Afbetaling;
import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.domain.Project;
import nl.ing.crowdfunding.domain.transformer.Terraformer;
import nl.ing.crowdfunding.service.AfbetalingService;
import nl.ing.crowdfunding.service.CommonAPIConnectionService;
import nl.ing.crowdfunding.service.InvesteringService;
import nl.ing.crowdfunding.service.ProjectService;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Hans on 13-11-2014.
 */


public class PaymentsScheduler {


    @Resource
    InvesteringService is;

    @Resource
    AfbetalingService as;

    @Resource
    ProjectService ps;

    @Scheduled(fixedDelay = 60000 * 5)
    public void runPayments() {

        List<Project> projects = ps.getAll();

        for (Project p : projects) {
            List<Afbetaling> afbetalingen = createNewPayments(checkProjectInvestmentsForDueDates(p));
            for (Afbetaling a : afbetalingen) {
                as.save(a);
            }
        }

    }

    private List<Afbetaling> createNewPayments(List<Investering> investerings) {
        List<Afbetaling> result = new ArrayList<>();

        for (Investering i : investerings) {

            try {
                CommonAPIConnectionService.doTransfer(Terraformer.i2t(i));
                result.add(Terraformer.i2a(i));
            } catch (Exception e) {
                //yam yam
            }
        }
        return result;
    }

    private List<Investering> checkProjectInvestmentsForDueDates(Project p) {
        List<Investering> betalen = new ArrayList<>();

        if ("loopt".equals(p.getStatus())) {
            List<String> candidates = p.getInvesteringIds();


            for (String id : candidates) {

                Investering candidate = is.getById(id);
                Iterator<Afbetaling> it = candidate.getAfbetalingen().iterator();
                int highestId = 0;
                while (it.hasNext()) {
                    int itId = it.next().getId();
                    if (itId > highestId) highestId = itId;
                }

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, -1);
                Date result = cal.getTime();


                if (result.after(candidate.getAfbetalingen().get(highestId).getDatumtijd())) {
                    betalen.add(candidate);
                }
            }
        }

        return betalen;
    }

}
