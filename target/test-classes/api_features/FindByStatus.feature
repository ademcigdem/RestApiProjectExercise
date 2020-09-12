@Api_pet
Feature: Validate how many pets have the status “available" and the name “doggie”.

  @live
  Scenario: Validate number of the pets in API server
    Given user send GET request to "/pet/findByStatus" endpoint
    And verify that status code 200 and content type "application/json"
    When the request for "available" pets status
    And should be pets status with the name "doggie"
    Then verify correct number of the pets count 26

  @wire_mock
  Scenario: Validate number of the pets in WireMock server
    Given user send GET request to "/pet/findByStatus" endpoint with wiremock
    And verify that status code 200 and content type "application/json"
    When the request for "available" pets status
    And should be pets status with the name "doggie"
    Then verify correct number of the pets count 10
