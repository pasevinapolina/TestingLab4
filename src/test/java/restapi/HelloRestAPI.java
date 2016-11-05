package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by user on 05.11.2016.
 */
public class HelloRestAPI {

    @BeforeClass
    public static void setBaseURI() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    //@Test
    public void simpleTest() {
        given().
                when().get("/")
                .then().statusCode(200);
    }

    //@Test
    public void getTest() {

        given().queryParam("userId", 1).
                when().get("/comments/1").
                then().body("email", equalTo("Eliseo@gardner.biz") );
    }

    //@Test
    public void postObject() {

        Post post = new Post();
        post.id = "102";
        post.userId = "10";
        post.setEmail("102post@email.com");
        post.setBody("iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium qu");

        Response r = given().body(post).
                    when().contentType(ContentType.JSON).
                        post("/posts");

        String body = r.getBody().asString();
        System.out.println(body);
    }

    //@Test
    public void postString () {

        given().body ("{\"userId\":\"10\","
                +"\"id\":\"101\","
                +"\"email\":\"StaffWriter@mail.com\"," +
                "\body\":\"la lal alalallalalalal\"}")
                .when ()
                .contentType (ContentType.JSON)
                .post ("/posts");
    }

    //@Test
    public void putTest() {

        Post post = new Post();
        post.setId("3");
        post.setUserId("1");
        post.setEmail("example@email.com");
        post.setBody("alalalalaalla");

        given().body(post).
                when().contentType(ContentType.JSON).
                    put("posts/3").
                then().statusCode(200);
    }

    @Test
    public void deleteTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/posts";
    }

    //@Test
    public void failedTest() {
        given().
                when().get("/hello").
                then().statusCode(404);
    }
}
