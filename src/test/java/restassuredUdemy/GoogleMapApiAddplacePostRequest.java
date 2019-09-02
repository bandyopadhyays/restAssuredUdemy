package restassuredUdemy;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static io.restassured.RestAssured.given;



public class GoogleMapApiAddplacePostRequest {

    @Test
    public void addPlaceThroughJsonBody() {
        RestAssured.baseURI = "http://216.10.245.166";

        Response rawResponse =
        given().
                queryParam("key","qaclick123").
                header("Content-Type","application/json").
                body("{\n" +
                        "\n" +
                        "    \"location\":{\n" +
                        "\n" +
                        "        \"lat\" : -38.383494,\n" +
                        "\n" +
                        "        \"lng\" : 33.427362\n" +
                        "\n" +
                        "    },\n" +
                        "\n" +
                        "    \"accuracy\":50,\n" +
                        "\n" +
                        "    \"name\":\"Frontline house new\",\n" +
                        "\n" +
                        "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                        "\n" +
                        "    \"address\" : \"29, side layout, cohen 09\",\n" +
                        "\n" +
                        "    \"types\": [\"shoe park\",\"shop\"],\n" +
                        "\n" +
                        "    \"website\" : \"http://google.com\",\n" +
                        "\n" +
                        "    \"language\" : \"French-IN\"\n" +
                        "\n" +
                        "}\n").
                when().
                post("/maps/api/place/add/json").
                then().
                assertThat().
                statusCode(200).
                extract().
                response();
        String response = rawResponse.asString();
        //System.out.println(response);
        JsonPath js = new JsonPath(response);
        System.out.println(js.get("place_id"));
    }

    @Test
    public void addPlaceThroughJsonFile() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String requestBody = new String(Files.readAllBytes(Paths.get("C:/Users/souni_apu/IdeaProjects/apiAutomationudemy/src/test/resources/addPlace.json")));

        Response rawResponse =
        given().
                queryParam("key","qaclick123").
                header("Content-Type","application/json").
                body(requestBody).
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

    @Test
    public void deletePlace() {
        RestAssured.baseURI = "http://216.10.245.166";

        Response rawResponse =
        given().
                queryParam("","").
                header("Content-Type","application/json").
                body("{\n" +
                        "    \"place_id\":\"2395feefae470bc3562d256f8d6a4f9d\"\n" +
                        "}\n" +
                        "\n").
                when().
                post("/maps/api/place/delete/json").
                then().
                extract().
                response();
        String response = rawResponse.asString();
        System.out.println(response);
    }
}
