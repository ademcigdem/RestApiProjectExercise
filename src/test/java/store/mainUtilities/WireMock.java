package store.mainUtilities;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import store.pojo.PetStatus;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Slf4j
public class WireMock {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    WireMockServer w_m_server;

    public void setup() {
        w_m_server = new WireMockServer(8000);
        w_m_server.start();
        setupServerStub();
        LOGGER.info("WireMock Server Setup Port 8000 Wire Mock Server");
    }


    public void setupServerStub() {
        w_m_server.stubFor(get(urlEqualTo("/v2/pet/findByStatus?status=available"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBodyFile("data/pets.json")));
    }

    public Response getStubbedResponse(PetStatus petStatus, String endpoint) {
        return given().
                when().
                get("http://localhost:8000" + "/v2" + endpoint + "?status=" + petStatus.toString());
    }


    public Response getStubbedResponseSecond(String endpoint) {
        return given().
                when().
                get("http://localhost:8000" + "/v2" + endpoint + "?status=available");

    }

    public void teardown() {
        w_m_server.stop();
        LOGGER.info("WireMock Server TearDown Port 8000 Wire Mock Server");
    }
}
