@settings @myExtension
Feature: Settings screen - My Extension item

  Scenario: Verify Making Calls Default Settings
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Settings screen
    And user clicks My Extension settings item
    Then My Extension page is displayed
    And each Extension can be selected