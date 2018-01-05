@texts
Feature: Texts

  Scenario Outline: Verify Texts contacts name
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Texts screen
    And creates contact with <contactName> for the <numberFrom> dialog
    Then all entities with <numberFrom> on Texts screen will be displayed with the <contactName> contact name

    Examples:
      | numberFrom                                    | contactName            |
      | (617) 249-0540                                | Contact1               |