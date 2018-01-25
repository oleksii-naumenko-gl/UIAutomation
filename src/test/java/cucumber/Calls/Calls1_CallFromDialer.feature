@calls
Feature: Calls

  Scenario: Verify Calling from Dialer
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Call screen
    Then user is able to perform call from dialer

