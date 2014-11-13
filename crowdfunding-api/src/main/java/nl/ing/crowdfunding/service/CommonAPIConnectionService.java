package nl.ing.crowdfunding.service;

import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Hans on 12-11-2014.
 */
@Service
public class CommonAPIConnectionService {

    private static final String TRANSFER_URL = "http://ingcommonapi-test.apigee.net/commonapi/v0/NL/transfers";

    public static int doTransfer() throws Exception {

        URL obj = new URL(TRANSFER_URL + "?" + "apikey=mfFhlcOcGwhPDDYrOBC3FgaBKe0cblQ5");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzI5NjAsIm5vbmNlIjoiZjM1YTIyNzctMzQ5YS00OWFjLTlmODctM2Y1ZWQ2NGFmZGE5IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNTMwMSIsImp0aSI6IjE5Njg2ZWE5LTliNzQtNDRhMS1iZWUxLWI2MDEwMzdhZmY4NyIsImlhdCI6MTQxNTgxMDIxM30.-eiFNxfOiVoduApAHYjvQhOUDqrIpGSd6On-Fv1zbMc");
        con.setRequestProperty("Content-Type", "application/json");

        String query = "{" +
                "  'sourceProductId' : 'NL49INGX0007174801'," +
                "  'sourceProductIdentification' : 'NL49INGX0007174801'," +
                "  'targetProductId' : 'T12365937'," +
                "  'targetProductIdentification' : 'T12365937'," +
                "  'targetCodeType' : {" +
                "    'code' : 'SDA'," +
                "    'label' : 'This is an account'" +
                "  }," +
                "  'targetCode' : 'T12365937'," +
                "  'targetBICCode' : 'INGBNL2A'," +
                "  'targetCustomerName' : 'Eric Manshande'," +
                "  'amount' : {" +
                "    'value' : 200," +
                "    'currency' : {" +
                "      'code' : 'EUR'," +
                "      'label' : '€'" +
                "    }" +
                "  }," +
                "  'commission' : {" +
                "    'value' : 0," +
                "    'currency' : {" +
                "      'code' : 'EUR'," +
                "      'label' : '€'" +
                "    }" +
                "  }," +
                "  'executionDate' : {" +
                "    'datetime' : '2014-11-13T00:00:00+01:00'" +
                "  }," +
                "  'transferType' : {" +
                "    'code' : 'C2C'," +
                "    'label' : ''" +
                "  }," +
                "  'description' : 'Payment reference #2'," +
                "  'paymentReference' : 'Automatic payment'" +
                "}";


        con.setDoOutput(true);


        if (query != null) {
            con.setRequestProperty("Content-Length", Integer.toString(query.length()));
            con.getOutputStream().write(query.getBytes("UTF8"));
        }

        InputStream response = con.getInputStream();

        int[] responseCodeList = new int[4];
        responseCodeList[0] = con.getResponseCode();

        

        int responseCode = 200;
        for (int code : responseCodeList) {
            if (code > responseCode) {
                responseCode = code;
                break;
            }
        }


        return responseCode;
    }


}
