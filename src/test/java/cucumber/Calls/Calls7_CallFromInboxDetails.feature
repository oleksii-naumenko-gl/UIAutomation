@calls
Feature: Calls

  Scenario: Verify Calling from Inbox details
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Inbox screen
    And opens first Voicemails details
    Then user is able to perform call from the Voicemail details

