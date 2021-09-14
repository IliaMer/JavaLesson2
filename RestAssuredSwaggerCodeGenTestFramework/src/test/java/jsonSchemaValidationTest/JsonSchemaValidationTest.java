package jsonSchemaValidationTest;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidationTest {
    @Test
    void validate() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("comments", "pleease");
        jsonObject.addProperty("custemail", "test@test.tt");
        jsonObject.addProperty("custname", "Turtle Donatello");
        jsonObject.addProperty("custtel", "+7999887766");
        jsonObject.addProperty("delivery", "12:45");
        jsonObject.addProperty("size", "medium");
        JsonArray toppings = new JsonArray();
        toppings.add("bacon");
        toppings.add("cheese");
        toppings.add("mashroom");
        jsonObject.add("topping", toppings);
        Response response = RestAssured.given().log().all().body(jsonObject.toString()).post("http://httpbin.org/post");
        System.out.println(response.asString());
        response.then().body(matchesJsonSchemaInClasspath("httpBeanJsonSchema.json").using(runJsonSchemaFactory()));
    }

    @Test
    void validateStoreInventoryTest() {
        Response response = RestAssured.get("https://petstore.swagger.io/v2/store/inventory");
        System.out.println(response.asString());
        response.then().body(matchesJsonSchemaInClasspath("storeInventorySchema.json").using(runJsonSchemaFactory()));
    }

    @RepeatedTest(3)
    void validateUserTest() {
        Response response = RestAssured.get("https://petstore.swagger.io/v2/user/user13");
        System.out.println(response.asString());
        response.then().body(matchesJsonSchemaInClasspath("getUserSchema.json").using(runJsonSchemaFactory()));
    }

    @Test
    void validateAddPetTest() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", 0);
        JsonArray categories = new JsonArray();
        categories.add(0);
        categories.add("bobik");
        jsonObject.addProperty("category", String.valueOf(categories));

        jsonObject.addProperty("name", "doggie");

        JsonArray photo = new JsonArray();
        photo.add("tttttttt");
        jsonObject.addProperty("photoUrls", String.valueOf(photo));
        JsonArray tagsAdd = new JsonArray();
        tagsAdd.add(0);
        tagsAdd.add("tobik");
        jsonObject.addProperty("tags", String.valueOf(tagsAdd));

        jsonObject.addProperty("status", "available");

        Response response = RestAssured.given().log().all().post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.asString());
        response.then().body(matchesJsonSchemaInClasspath("petAddSchema.json").using(runJsonSchemaFactory()));
    }

    private JsonSchemaFactory runJsonSchemaFactory() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder()
                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
        return jsonSchemaFactory;
    }
}