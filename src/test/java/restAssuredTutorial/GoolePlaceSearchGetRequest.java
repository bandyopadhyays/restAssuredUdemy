package restAssuredTutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class GoolePlaceSearchGetRequest {

    @Test
    public void googlePlaceSearch() {
        RestAssured.baseURI = "https://maps.googleapis.com";

        Response rawResponse =
        given().

                queryParam("key","AIzaSyAltft1d2Oz5rdXIhE7-F6WCoANHv3z6ME").
                when(). queryParam("location","-33.8670522,151.1957362").
                queryParam("radius","1500").
                get("/maps/api/place/nearbysearch/json").
                then().
                assertThat().
                statusCode(200).
                and().
                header("X-Frame-Options",equalTo("SAMEORIGIN")).
                and().
                header("Content-Length",startsWith("78")).
                and().
                body("results[0].photos.height",equalTo("3120")).
                extract().
                response();
        String response = rawResponse.asString();
    }
}
