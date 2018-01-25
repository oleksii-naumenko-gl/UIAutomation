@calls
Feature: Calls

  Scenario: Verify Calling from Favorites
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Call screen
    And opens Favorites screen
    Then user is able to perform call from the Favorites screen

