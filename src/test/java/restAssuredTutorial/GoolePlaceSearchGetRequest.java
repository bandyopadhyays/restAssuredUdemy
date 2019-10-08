package restAssuredTutorial;

import io.restassured.RestAssured;
<<<<<<< HEAD
=======
import io.restassured.path.json.JsonPath;
>>>>>>> updated
import io.restassured.response.Response;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

<<<<<<< HEAD
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
=======
public class GoolePlaceSearchGetRequest extends GooleTestBase {

    @Test
    public void googlePlaceSearch() {

        Response res =
        given().
                queryParam("location","-33.8670522,151.1957362").
                queryParam("radius","1500").
                queryParam("key","AIzaSyAltft1d2Oz5rdXIhE7-F6WCoANHv3z6ME").
                when().
                get().
                then().
                extract().
                response();
        //System.out.println(res.asString());
        JsonPath js = new JsonPath(res.asString());
        System.out.println(js.get("results.size"));
        int totalResult = js.get("results.size");
        for (int i = 0; i < totalResult; i++)
            System.out.println(js.get("results[" + i + "].name"));
>>>>>>> updated
    }
}
