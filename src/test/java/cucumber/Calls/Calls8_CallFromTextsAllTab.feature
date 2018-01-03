@calls
Feature: Grasshopper Smoke Test

  Scenario: Verify Calling from Texts All tab
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Texts screen
    And user opens All tab on Texts
    Then user is able to perform call from the Texts using swipe menu

