@incomingCalls @settings @ignored
Feature: Settings

  Scenario Outline: Verify Incoming calls section
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Settings screen
    Then Settings screen is displayed
    When user clicks Call Forwarding settings item
    Then Call Forwarding page is displayed
    And all extensions are displayed on Call Forwarding page
    When user adds new forwarding number for <extension> extension
    And user edits forwarding number for <extension> extension
    And unchecks/checks forwarding number
    Then forwarding number for <extension>  extension can be deleted

    Examples:
      | extension |
      | Ext 0     |
      | Ext 1     |
