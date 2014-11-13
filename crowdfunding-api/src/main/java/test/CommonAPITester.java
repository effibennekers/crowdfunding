package test;

import nl.ing.crowdfunding.service.CommonAPIConnectionService;
import org.junit.Test;

/**
 * Created by Hans on 13-11-2014.
 */
public class CommonAPITester {

    @Test
    public void commonAPITest() {
        try {
            int result = CommonAPIConnectionService.doTransfer();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
