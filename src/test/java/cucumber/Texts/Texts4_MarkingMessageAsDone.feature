@Texts
Feature: Grasshopper Smoke Test

  Scenario Outline: Verify Unread Counter For Text Icon
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Texts screen
    And marks unread message from <numberFrom> as Done
    Then unread counter for Texts is updated
    And message from <numberFrom> is moved to Done tab
    And message from <numberFrom> is displayed without New icon

    Examples:
      | numberFrom                                    |
      | (617) 249-0540                                |