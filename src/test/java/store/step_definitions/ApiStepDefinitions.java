package store.step_definitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import store.pojo.PetStatus;
import store.pojo.Petstore;
import store.request.Request;


import static org.junit.Assert.*;

public class ApiStepDefinitions {
    Response response;
    Request getRequest = new Request();
    int count;
    public static boolean wireMockPoint = false;

    @Given("user send GET request to {string} endpoint")
    public void user_send_get_request_to_endpoint(String endpoint) {
        response = getRequest.getEndPoint(endpoint);
    }

    @Given("user send GET request to {string} endpoint with wiremock")
    public void userSendGETRequestToEndpointWithWiremock(String endpoint) {
        wireMockPoint = true;
        response= getRequest.getEndPoint(endpoint);
    }

    @Given("verify that status code {int} and content type {string}")
    public void verify_that_status_code_and_content_type(int statusCode, String contentType) {
        response.then().assertThat().statusCode(statusCode).contentType(contentType);
    }

    @When("the request for {string} pets status")
    public void the_request_for_pets_status(String available) {
        response = getRequest.getPetsByStatus(PetStatus.valueOf(available));
    }

    @When("should be pets status with the name {string}")
    public void should_be_pets_status_with_the_name(String name) {
        Petstore[] petstore = response.body().as(Petstore[].class);
        for (Petstore allpet : petstore) {
            try{
            if(allpet.getName().equals(name)){
                count++;
            }
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    @Then("verify correct number of the pets count {int}")
    public void verifyCorrectNumberOfThePetsCount (int expectedNameCount) {
        assertTrue("Verify doggie names count bigger than 0 ",count>0);
        assertEquals("Verify doggie names count ",expectedNameCount,count);
    }

}
