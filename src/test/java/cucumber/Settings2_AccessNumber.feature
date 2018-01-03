@settings @accessNumber
Feature: Settings screen - Access Number

  Scenario: Verify Access Number Default Settings
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Settings screen
    And user clicks Access Number settings item
    Then Access Number page is displayed
    And Use plus one while dialing option can be switched
    And each access number option can be selected
