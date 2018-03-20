@texts
Feature: Texts

  Scenario Outline: Verify Texts contacts name
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Texts screen
    And creates contact with <contactName> for the dialog
    Then all entries with the number are replaced with <contactName> contact name

    Examples:
      | contactName |
      | Contact1    |