import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by user on 05.11.2016.
 */
public class HelloRestAPITest {


    private final String URL = "http://jsonplaceholder.typicode.com";
    private final String CONTENT_TYPE = "application/json";

    @Test
    public void getPost1() {
        given().contentType(CONTENT_TYPE)
                .when()
                .get(URL + "/posts/1")
                .then()
                .body(containsString("userId"))
                .body(containsString("id"))
                .body(containsString("title"))
                .body(containsString("body"))
                .statusCode(200);
    }

    @Test
    public void postPosts() {
        given().contentType(CONTENT_TYPE)
                .when()
                .post(URL + "/posts")
                .then()
                .body(containsString("id"))
                .statusCode(201);
    }

    @Test
    public void putPosts1() {
        given().contentType(CONTENT_TYPE)
                .when()
                .put(URL + "/posts/1")
                .then()
                .body(containsString("id"))
                .statusCode(200);
    }

    @Test
    public void deletePosts1() {
        given().contentType("application/json")
                .when()
                .delete(URL + "/posts/1")
                .then()
                .body(containsString(""))
                .statusCode(200);
    }

    @Test
    public void incorrect() {
        given().contentType("application/json")
                .when()
                .delete(URL + "/posts/fail")
                .then()
                .body(containsString(""))
                .statusCode(404);
    }
//    @BeforeClass
//    public static void setBaseURI() {
//        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
//    }
//
//    @Test
//    public void simpleTest() {
//        given().
//                when().get("/")
//                .then().statusCode(200);
//    }
//
//    @Test
//    public void getTest() {
//
//        given().queryParam("userId", 1).
//                when().get("/comments/1").
//                then().body("email", equalTo("Eliseo@gardner.biz") );
//    }
//
//    @Test
//    public void postObject() {
//
//        Post post = new Post();
//        post.id = "102";
//        post.userId = "10";
//        post.setEmail("102post@email.com");
//        post.setBody("iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium qu");
//
//        Response r = given().body(post).
//                    when().contentType(ContentType.JSON).
//                        post("/posts");
//
//        String body = r.getBody().asString();
//        System.out.println(body);
//    }
//
//    @Test
//    public void postString () {
//
//        given().body ("{\"userId\":\"10\","
//                +"\"id\":\"101\","
//                +"\"email\":\"StaffWriter@mail.com\"," +
//                "\body\":\"la lal alalallalalalal\"}")
//                .when ()
//                .contentType (ContentType.JSON)
//                .post ("/posts");
//    }
//
//    @Test
//    public void putTest() {
//
//        Post post = new Post();
//        post.setId("3");
//        post.setUserId("1");
//        post.setEmail("example@email.com");
//        post.setBody("alalalalaalla");
//
//        given().body(post).
//                when().contentType(ContentType.JSON).
//                    put("posts/3").
//                then().statusCode(200);
//    }
//
//    @Test
//    public void deleteTest() {
//        given().pathParam("id", 1).
//            when().
//                delete("/posts/{id}").
//            then().statusCode(200);
//    }
//
//    @Test
//    public void failedTest() {
//        given().
//                when().get("/hello").
//                then().statusCode(404);
//    }
}
