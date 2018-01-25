@settings @makingCalls
Feature: Settings

  Scenario: Verify Making Calls Default Settings
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Settings screen
    And user clicks Making Calls settings item
    Then Making Calls page is displayed
    And each making calls option can be selected