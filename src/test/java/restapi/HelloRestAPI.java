package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

        String myJson = "{\"id\":\"1\"}";

        Response r = given()
                .contentType("application/json").
                        body("{\"id\":\"1\"}").
                        when().
                        post("");

        String body = r.getBody().asString();
        System.out.println(body);
    }

    @Test
    public void updateTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/posts/1";

    }

    @Test
    public void deleteTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/posts";
    }

    @Test
    public void failedTest() {
        given().
                when().get("http://google.com/12").
                then().statusCode(404);
    }

}
