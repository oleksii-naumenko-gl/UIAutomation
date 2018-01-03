@Texts
Feature: Grasshopper Smoke Test

  Scenario Outline: Verify Unread Counter For Text Icon
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Texts screen
    And sends new text message from <numberFrom> to <numberTo>
    Then unread counter for Texts is updated

    Examples:
      | numberFrom                                    | numberTo            |
      | (617) 249-0540                                | 6172213553              |