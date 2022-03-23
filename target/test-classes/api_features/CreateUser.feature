@createUser
Feature: Creating the new user at the petStore page

  Scenario: Using the POST request and adding new user at the page
    Given load the body from userCreateRequest.json
    When use the user end point with the POST request
    Then status code should be 200
    And response body should match with schema file userCreatedSchema.json

