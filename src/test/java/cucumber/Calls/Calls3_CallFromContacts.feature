@calls
Feature: Calls

  Scenario: Verify Calling from Contacts
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Call screen
    And opens Contacts screen
    Then user is able to perform call from the Contacts screen

