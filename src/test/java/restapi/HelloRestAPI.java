package restapi;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by user on 05.11.2016.
 */
public class HelloRestAPI {

    @Test
    public void simpleTest() {
        given().
                when().get("http://jsonplaceholder.typicode.com")
                .then().statusCode(200);
    }

    @Test
    public void getTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/comments";

        given().queryParam("id", 1).
                when().get("1").
                then().body("email", equalTo("Eliseo@gardner.biz") );
    }

    @Test
    public void postTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/posts";

        
    }

}
