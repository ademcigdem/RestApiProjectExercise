package store.request;

import io.restassured.response.Response;
import store.pojo.PetStatus;
import store.step_definitions.ApiStepDefinitions;
import store.step_definitions.Hooks;

import static io.restassured.RestAssured.*;

public class Request {

    Response response;
    String endPoint;



    public Response getEndPoint(String endPoint) {
        this.endPoint = endPoint;
        if (ApiStepDefinitions.wireMockPoint) {
            response = Hooks.wireMock.getStubbedResponseSecond(endPoint);
        } else {
            response = given().get(endPoint);
        }
        return response;
    }


    public Response getPetsByStatus(PetStatus petStatus) {
        if (ApiStepDefinitions.wireMockPoint) {
            response = Hooks.wireMock.getStubbedResponse(petStatus, endPoint);
        } else {
            response = given().param("status", petStatus.toString())
                    .when().get(endPoint);
        }
        return response;
    }

}


