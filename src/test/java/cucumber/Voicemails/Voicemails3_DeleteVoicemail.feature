@voicemails
Feature: Voicemail

  Scenario: Verify Voicemail can be deleted
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Inbox screen
    And deletes first Inbox entry
    Then it is removed from the Inbox tab
    And is moved to Deleted tab




