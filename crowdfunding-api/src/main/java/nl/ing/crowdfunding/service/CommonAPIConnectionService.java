package nl.ing.crowdfunding.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by Hans on 12-11-2014.
 */
@Service
public class CommonAPIConnectionService {

  private static final String TRANSFER_URL = "http://ingcommonapi-test.apigee.net/commonapi/v0/NL/transfers";

  public static int doTransfer() throws Exception {

    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(TRANSFER_URL + "?" + "apikey=mfFhlcOcGwhPDDYrOBC3FgaBKe0cblQ5");

    post.setHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzI5NjAsIm5vbmNlIjoiZjM1YTIyNzctMzQ5YS00OWFjLTlmODctM2Y1ZWQ2NGFmZGE5IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNTMwMSIsImp0aSI6IjE5Njg2ZWE5LTliNzQtNDRhMS1iZWUxLWI2MDEwMzdhZmY4NyIsImlhdCI6MTQxNTgxMDIxM30.-eiFNxfOiVoduApAHYjvQhOUDqrIpGSd6On-Fv1zbMc");
    post.setHeader("Content-Type", "application/json");

    String query = "{\n" +
      "  \"sourceProductId\" : \"NL49INGX0007174801\",\n" +
      "  \"sourceProductIdentification\" : \"NL49INGX0007174801\",\n" +
      "  \"targetProductId\" : \"T12365937\",\n" +
      "  \"targetProductIdentification\" : \"T12365937\",\n" +
      "  \"targetCodeType\" : {\n" +
      "    \"code\" : \"SDA\",\n" +
      "    \"label\" : \"This is an account\"\n" +
      "  },\n" +
      "  \"targetCode\" : \"T12365937\",\n" +
      "  \"targetBICCode\" : \"INGBNL2A\",\n" +
      "  \"targetCustomerName\" : \"Eric Manshande\",\n" +
      "  \"amount\" : {\n" +
      "    \"value\" : 200,\n" +
      "    \"currency\" : {\n" +
      "      \"code\" : \"EUR\",\n" +
      "      \"label\" : \"€\"\n" +
      "    }\n" +
      "  },\n" +
      "  \"commission\" : {\n" +
      "    \"value\" : 0,\n" +
      "    \"currency\" : {\n" +
      "      \"code\" : \"EUR\",\n" +
      "      \"label\" : \"€\"\n" +
      "    }\n" +
      "  },\n" +
      "  \"executionDate\" : {\n" +
      "    \"datetime\" : \"2014-11-13T00:00:00+01:00\"\n" +
      "  },\n" +
      "  \"transferType\" : {\n" +
      "    \"code\" : \"C2C\",\n" +
      "    \"label\" : \"\"\n" +
      "  },\n" +
      "  \"description\" : \"Payment reference #2\",\n" +
      "  \"paymentReference\" : \"Automatic payment\"\n" +
      "}";


   post.setEntity( new ByteArrayEntity(query.getBytes("UTF-8")));


  HttpResponse response = client.execute(post);


    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> jsonMap = mapper.readValue(response.getEntity().getContent(), Map.class);

    int[] responseCodeList = new int[4];

    responseCodeList[0] = response.getStatusLine().getStatusCode();

    int responseCode = 200;
    for (int code : responseCodeList) {
      if (code > responseCode) {
        responseCode = code;
        break;
      }
    }

    System.out.println(jsonMap);

    return responseCode;
  }


}
