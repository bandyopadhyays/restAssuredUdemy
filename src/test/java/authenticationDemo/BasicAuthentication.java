package authenticationDemo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BasicAuthentication {

    @Test
    public void basicAuthDemo() {

        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

        int statusCode =
        RestAssured.given()
                .auth().
                preemptive().
                basic("ToolsQA","TestPassword").
                when().
                get().
                getStatusCode();

        System.out.println("Status Code is - " + statusCode);
    }
}
