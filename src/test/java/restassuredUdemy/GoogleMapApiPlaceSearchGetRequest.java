package restassuredUdemy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.equalTo;

public class GoogleMapApiPlaceSearchGetRequest {

    @Test
    public void googlePlaceSearchUsingGetRequest() {
        RestAssured.baseURI = "https://maps.googleapis.com/";
        Response response =
        given().
                queryParam("location","-33.8670522,151.1957362").
                queryParam("radius","1500").
                queryParam("key","AIzaSyAltft1d2Oz5rdXIhE7-F6WCoANHv3z6ME").
                when().
                get("maps/api/place/nearbysearch/json").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                header("X-Frame-Options", equalTo("SAMEORIGIN")).
                and().
                body("results[0].name",equalTo("Sydney")).
                extract().
                response();
        String responseString = response.asString();
        //System.out.println(responseString);
        JsonPath js = new JsonPath(responseString);
        System.out.println( js.get("results[0].name"));

    }
}