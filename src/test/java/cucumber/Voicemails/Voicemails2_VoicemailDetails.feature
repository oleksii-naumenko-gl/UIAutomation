@Voicemails
Feature: Grasshopper Smoke Test

  Scenario: Verify new Voicemail
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Inbox screen
    And opens any new Inbox entry
    Then Voicemail details are shown
    And unread counter for Voicemails is updated
    And blue dot is removed from that entry



