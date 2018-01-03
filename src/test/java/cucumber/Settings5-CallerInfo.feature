@callerInfo
Feature: Settings screen - Caller Info switch

  Scenario: Verify Caller Info is turned off by default
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Settings screen
    And Caller Info switch can be turned ON/OFF