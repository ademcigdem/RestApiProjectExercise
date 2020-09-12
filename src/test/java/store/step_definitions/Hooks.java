package store.step_definitions;

import io.cucumber.java.*;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import store.mainUtilities.ConfigReader;
import store.mainUtilities.WireMock;

import java.util.logging.Logger;

@Slf4j
public class Hooks {
    private static Logger logger = Logger.getLogger(String.valueOf(Hooks.class));
    public static WireMock wireMock = new WireMock();

    @Before
    public void setup() {
        RestAssured.baseURI = ConfigReader.get("url");
        RestAssured.basePath = ConfigReader.get("base_path");
        logger.info("@Before setup for API SERVER");
    }

    @After
    public void tearDown() {
        logger.info("@After tearDown for API SERVER");

    }

    @Before("@wire_mock")
    public void setupWireMock() {
        wireMock.setup();
        logger.info("@Before setup for WireMock SERVER");
    }

    @After("@wire_mock")
    public void tearDownWireMock() {
        wireMock.teardown();
        logger.info("@After tearDown for WireMock SERVER");
    }
}
