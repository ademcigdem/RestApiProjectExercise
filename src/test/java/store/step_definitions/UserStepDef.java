package store.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import store.actions.ModelSession;

import java.io.File;

import static io.restassured.RestAssured.*;


public class UserStepDef {

    ModelSession session = new ModelSession();


    @Given("^use the (.*) end point with the (.*) request$")
    public void useTheWithTheRequest(String endPoint, String request) throws Exception {
        session.requestMethod(request,endPoint);
    }

    @When("^load the body from (.*)$")
    public void loadTheBodyFrom(String requestBodyPath) {
        session.resourcePath(requestBodyPath);
    }

    @Then("^status code should be (\\d+)$")
    public void statusCodeShouldBe(int statusCode) {
        session.statusCode(statusCode);
    }

    @And("^response body should match with schema file (.*)$")
    public void responseBodyShouldMatchWithSchemaFile(String filePath) {
        session.schemaValidation(filePath);
    }



    //session.response = given()
    //                .contentType(ContentType.JSON)
    //                .accept("application/json")
    //                .body(new File("src/test/resources/requestBody/userCreateRequest.json"))
    //                .when()
    //                .post(endPoint);
    //        session.response.then().statusCode(200)
    //                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("resonseSchema/userCreatedSchema.json"));
}
