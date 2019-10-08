package pojoExample;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FinalPayload {

    public  static void main(String[] args) throws JsonProcessingException {
        String [] types =  {"shoe park", "Shop"};
        Location location = new Location();
        location.setLat("-38.383494");
        location.setLng("33.427362");

        Payload payload = new Payload();
        payload.setLocation(location);
        payload.setAccurecy(50);
        payload.setName("Frontline house new1");
        payload.setPhone_number("(+91) 983 893 1234");
        payload.setAddress("29, side layout, cohen 09");
        payload.setTypes(types);
        payload.setWebsite("http://google.com");
        payload.setLanguage("French-IN");

        ObjectMapper objMap = new ObjectMapper();
        String data = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
        System.out.println(data);

        RestAssured.baseURI = "http://216.10.245.166";


        Response rawResponse =
                given().
                        queryParam("key","qaclick123").
                        header("Content-Type","application/json").
                        body(payload).
                        when().
                        post("/maps/api/place/add/json").
                        then().
                        assertThat().
                        statusCode(200).
                        extract().
                        response();
        String response = rawResponse.asString();
        System.out.println(response);

    }
}
