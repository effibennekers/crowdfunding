package nl.ing.crowdfunding.service;

import nl.ing.crowdfunding.domain.ing.common.Transfer;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hans on 12-11-2014.
 */
@Service
public class CommonAPIConnectionService {

    private static final String TRANSFER_URL = "http://ingcommonapi-test.apigee.net/commonapi/v0/NL/transfers";
    private static final String ACCOUNTS_URL = "http://ingcommonapi-test.apigee.net/commonapi/v0/NL/persons/15301/accounts/";
    private static CloseableHttpClient client = HttpClients.createDefault();

    public static int doTransfer(Transfer mrT) throws Exception {


        HttpPost post = new HttpPost(TRANSFER_URL + "?" + "apikey=mfFhlcOcGwhPDDYrOBC3FgaBKe0cblQ5");

        post.setHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzI5NjAsIm5vbmNlIjoiZjM1YTIyNzctMzQ5YS00OWFjLTlmODctM2Y1ZWQ2NGFmZGE5IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNTMwMSIsImp0aSI6IjE5Njg2ZWE5LTliNzQtNDRhMS1iZWUxLWI2MDEwMzdhZmY4NyIsImlhdCI6MTQxNTgxMDIxM30.-eiFNxfOiVoduApAHYjvQhOUDqrIpGSd6On-Fv1zbMc");
        post.setHeader("Content-Type", "application/json");

        String query = paymentFormatter(mrT.getFromAccount(), mrT.getAmount(), mrT.getToAccount(), mrT.getToName());
        System.out.println(query);

        post.setEntity(new ByteArrayEntity(query.getBytes("UTF-8")));


        HttpResponse response = client.execute(post);


        return processOrder(response);
    }

    private static String paymentFormatter(String fromAccount, String amount, String toAccount, String toName) {

        return
                "{\n" +
                        "  \"sourceProductId\" : \"" + fromAccount + "\",\n" +
                        "  \"sourceProductIdentification\" : \"" + fromAccount + "\",\n" +
                        "  \"targetProductId\" : \"" + toAccount + "\",\n" +
                        "  \"targetProductIdentification\" : \"" + toAccount + "\",\n" +
                        "  \"targetCodeType\" : {\n" +
                        "    \"code\" : \"SDA\",\n" +
                        "    \"label\" : \"This is an account\"\n" +
                        "  },\n" +
                        "  \"targetCode\" : \"" + toAccount + "\",\n" +
                        "  \"targetBICCode\" : \"INGBNL2A\",\n" +
                        "  \"targetCustomerName\" : \"" + toName + "\",\n" +
                        "  \"amount\" : {\n" +
                        "    \"value\" : \"" + amount + "\",\n" +
                        "    \"currency\" : {\n" +
                        "      \"code\" : \"EUR\",\n" +
                        "      \"label\" : \"\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"commission\" : {\n" +
                        "    \"value\" : 0,\n" +
                        "    \"currency\" : {\n" +
                        "      \"code\" : \"EUR\",\n" +
                        "      \"label\" : \"\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"executionDate\" : {\n" +
                        "    \"datetime\" : \"2014-11-13T00:00:00\"\n" +
                        "  },\n" +
                        "  \"transferType\" : {\n" +
                        "    \"code\" : \"C2C\",\n" +
                        "    \"label\" : \"\"\n" +
                        "  },\n" +
                        "  \"description\" : \"Payment reference #2\",\n" +
                        "  \"paymentReference\" : \"Automatic payment\"\n" +
                        "}";


    }

    private static int processOrder(HttpResponse order) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        int statusCode = order.getStatusLine().getStatusCode();
        while (200 == statusCode) {

            if (order.getEntity() != null) {
                BufferedHttpEntity e = new BufferedHttpEntity(order.getEntity());

                JsonNode initiateResult = mapper.readValue(e.getContent(), JsonNode.class);

                JsonNode links = initiateResult.findValue("links");
                System.out.println(links);
                System.out.println(initiateResult);
                for (JsonNode link : links) {
                    if ("signing_url".equals(link.findValuesAsText("rel").get(0)) || "execute_url".equals(link.findValuesAsText("rel").get(0))) {
                        String href = link.findValuesAsText("href").get(0);

                        HttpPut signRequest = new HttpPut("http://ingcommonapi-test.apigee.net/commonapi/v0/NL/" + href + "?" + "apikey=mfFhlcOcGwhPDDYrOBC3FgaBKe0cblQ5");
                        signRequest.setHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzI5NjAsIm5vbmNlIjoiZjM1YTIyNzctMzQ5YS00OWFjLTlmODctM2Y1ZWQ2NGFmZGE5IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNTMwMSIsImp0aSI6IjE5Njg2ZWE5LTliNzQtNDRhMS1iZWUxLWI2MDEwMzdhZmY4NyIsImlhdCI6MTQxNTgxMDIxM30.-eiFNxfOiVoduApAHYjvQhOUDqrIpGSd6On-Fv1zbMc");
                        signRequest.setHeader("Content-Type", "application/json");

                        signRequest.setEntity(e);


                        HttpResponse response = client.execute(signRequest);


                        return processOrder(response);


                    }
                }
            }
        }
        return statusCode;

    }


    public static List<String> getAccountNumbers() throws Exception {
        List<String> result = new ArrayList<>();
        HttpGet get = new HttpGet(ACCOUNTS_URL + "?" + "apikey=mfFhlcOcGwhPDDYrOBC3FgaBKe0cblQ5");

        get.setHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzI5NjAsIm5vbmNlIjoiZjM1YTIyNzctMzQ5YS00OWFjLTlmODctM2Y1ZWQ2NGFmZGE5IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNTMwMSIsImp0aSI6IjE5Njg2ZWE5LTliNzQtNDRhMS1iZWUxLWI2MDEwMzdhZmY4NyIsImlhdCI6MTQxNTgxMDIxM30.-eiFNxfOiVoduApAHYjvQhOUDqrIpGSd6On-Fv1zbMc");
        get.setHeader("Content-Type", "application/json");

        HttpResponse response = client.execute(get);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(response.getEntity().getContent(), JsonNode.class);
        result.addAll(node.findValuesAsText("id"));

        return result;
    }
}


