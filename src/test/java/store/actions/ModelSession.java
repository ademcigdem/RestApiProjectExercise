package store.actions;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ModelSession {

    private static ModelSession instance;

    private Map<String, String> globalResource;

    public Response response;
    public RequestSpecBuilder requestSpecBuilder;
    public RequestSpecification httpRequest = RestAssured.given();
    public JsonObject requestJsonBody = new JsonObject();
    public String filePath;


    public void requestMethod(String method, String endPoint) throws Exception {

        switch (method) {
            case "GET":
                response = httpRequest.request(Method.GET, endPoint);
                break;
            case "POST":
                response = httpRequest.headers(headerLoader())
                        .body(new File(filePath))
                        .request(Method.POST, endPoint);
                response.prettyPrint();
                break;
            case "PUT":
                response = given(httpRequest).put(endPoint);
                break;
            case "DELETE":
                response = given(httpRequest).delete(endPoint);
                break;
            default:
                throw new Exception("Unsupported request method : " + method);
        }


    }

    private Map<String, String> headerLoader() {
        Map<String, String> requestHeader = new HashMap<>();
        requestHeader.put("Content-Type", "application/json");
        requestHeader.put("accept", "application/json");
        return requestHeader;
    }

    public void resourcePath(String resourcePath){
        String path = "src/test/resources/requestBody/";
        filePath = path + resourcePath;
    }

    public void statusCode(int statusCode){
        response.then().statusCode(statusCode);
    }

    public void schemaValidation(String filePath){
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/"+filePath));
    }



}
