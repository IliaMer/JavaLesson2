package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetstoreTests {

    @Test
    void checkContentTypeInResponse() {
        Response response = RestAssured
                .given()
                .log().all()
                .header("Accept","application/xml")
                .get("https://petstore.swagger.io/v2/user/user1");

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/xml", response.contentType());
    }

    @Test
    void createUserTest() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{\"username\":\"testUser\"}")
                .post("https://petstore.swagger.io/v2/user");

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertFalse(response.getBody().asString().isEmpty());
        //Assertions.assertEquals("application/xml", response.contentType());
    }
}
