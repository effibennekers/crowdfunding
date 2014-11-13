package test;

import nl.ing.crowdfunding.domain.ing.common.Transfer;
import nl.ing.crowdfunding.engine.PaymentsScheduler;
import nl.ing.crowdfunding.service.CommonAPIConnectionService;
import nl.ing.crowdfunding.service.ProjectService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;


/**
 * Created by Hans on 13-11-2014.
 */
public class CommonAPITester {

    @Test
    public void commonAPITest() {
        try {

          Transfer transfer = new Transfer("NL49INGX0007174801","10","NL11INGB0005226376","Pipo");
            int result = CommonAPIConnectionService.doTransfer(transfer);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
