@texts
Feature: Texts

  Scenario: Verify Unread Counter For Text Icon
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Texts screen
    And marks unread message as Done
    Then unread counter for Texts is updated
    And message marked as Done is moved to Done tab
    And moved message is displayed without New icon