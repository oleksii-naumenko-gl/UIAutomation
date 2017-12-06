@calls
Feature: Grasshopper Smoke Test

  Scenario: Verify Calling from Recent
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Recent screen
    Then user is able to perform call from the Recent screen by clicking an existing entry

