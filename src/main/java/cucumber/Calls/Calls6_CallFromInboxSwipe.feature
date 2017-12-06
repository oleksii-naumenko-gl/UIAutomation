@calls
Feature: Grasshopper Smoke Test

  Scenario: Verify Calling from Inbox using Swipe menu
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Inbox screen
    Then user is able to perform call from the Inbox screen by using swipe menu

