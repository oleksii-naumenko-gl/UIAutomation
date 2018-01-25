@calls
Feature: Calls

  Scenario: Verify Calling from Texts Done tab
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Texts screen
    And user opens Done tab on Texts
    And checks there are messages marked as Done
    Then user is able to perform call from the Texts using swipe menu

