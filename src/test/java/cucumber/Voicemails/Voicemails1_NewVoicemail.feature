@voicemails
Feature: Voicemail

  Scenario Outline: Verify new Voicemail
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Call screen
    And leaves new Voicemail from <fromNumber> to <toNumber>
    Then unread counter for Voicemails is updated
    When user navigates to Inbox screen
    Then new Inbox entry from <fromNumber> is displayed with <toNumber>


    Examples:
      | fromNumber                           |   toNumber                                         |
      | (617) 249-0540                       |   (617) 221-3553                                   |


