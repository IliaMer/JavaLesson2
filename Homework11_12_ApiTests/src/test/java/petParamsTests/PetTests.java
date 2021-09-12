package petParamsTests;

import io.qameta.allure.Feature;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import petParams.Pet;


@Feature("Pet test")
public class PetTests {

    @Test
    void CreatePetTest() {
        Pet actualPet = new Pet();
        Long id = actualPet.getId();
        Response response = RestAssured
                .given()
                .log().all()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .body(actualPet)
                .post("https://petstore.swagger.io/v2/pet");

        Pet expectedPet = RestAssured
                .given()
                .log().all()
                .get("https://petstore.swagger.io/v2/pet" + id).as(Pet.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(expectedPet.getStatus(), "available");
        Assertions.assertEquals(expectedPet.getId(), id); //Ne poimu pochemu padaet
    }

    @Test
    void GetPetByIdTest() {
        Pet actualPet = new Pet();
        Long id = actualPet.getId();
        Pet response = RestAssured
                .given()
                .log().all()
                .get("https://petstore.swagger.io/v2/pet" + id).as(Pet.class);

        Assertions.assertFalse(response.getStatus().isEmpty());
        Assertions.assertFalse(response.getCategory().getName().isEmpty());
        System.out.println(response.toString());
    }

    @Test
    void PutPet() {
        Pet actualPutPet = new Pet();
        Long id = actualPutPet.getId();
        Response response = RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(actualPutPet)
                .put("https://petstore.swagger.io/v2/pet");

        Pet expectedPutPet = RestAssured
                .given()
                .log().all()
                .get("https://petstore.swagger.io/v2/pet" + id).as(Pet.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(expectedPutPet.getStatus(), "available");
        Assertions.assertEquals(expectedPutPet.getId(), id);
    }

    @Test
    void DeletePetTest() {
        Pet actualPet = new Pet();
        Long id = actualPet.getId();
        Response response = RestAssured
                .given()
                .log().all()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .body(actualPet)
                .post("https://petstore.swagger.io/v2/pet");

        RestAssured.delete("https://petstore.swagger.io/v2/pet" + id);
        Response expectedPet = RestAssured.get("https://petstore.swagger.io/v2/pet" + id);

        Assertions.assertEquals(404, expectedPet.getStatusCode());
    }
}
