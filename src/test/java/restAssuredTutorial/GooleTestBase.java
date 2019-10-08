package restAssuredTutorial;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class GooleTestBase {

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
        RequestSpecification request = RestAssured.given();
        request.queryParam("key","AIzaSyAltft1d2Oz5rdXIhE7-F6WCoANHv3z6ME");

    }

}
