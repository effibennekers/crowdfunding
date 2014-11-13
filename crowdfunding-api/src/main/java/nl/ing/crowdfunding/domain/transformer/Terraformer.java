package nl.ing.crowdfunding.domain.transformer;

import nl.ing.crowdfunding.domain.Afbetaling;
import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.domain.ing.common.Transfer;
import nl.ing.crowdfunding.service.KlantService;
import nl.ing.crowdfunding.service.ProjectService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Hans on 13-11-2014.
 */
public class Terraformer {

    @Resource
    static KlantService k;

    @Resource
    static ProjectService p;

    public static Transfer i2t(Investering i) {
        return new Transfer(k.getById(Integer.toString(p.getById(Integer.toString(i.getProject())).getEigenaar())).getDebtoriban(), String.valueOf(i.getBedrag()), k.getById(Integer.toString(i.getInvesteerder())).getCreditoriban(), k.getById(Integer.toString(i.getInvesteerder())).getAchternaam());

    }

    public static Afbetaling i2a(Investering i) {
        Afbetaling a = new Afbetaling();
        a.setBedrag(i.getBedrag());
        a.setDatumtijd(new Date());
        a.setId(i.getAfbetalingen().size() + 1);
        a.setInvestering(i.getId());

        return a;
    }

}
