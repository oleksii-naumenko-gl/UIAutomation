@incomingCalls @setiings @ignored
Feature: Settings

  Scenario Outline: Verify Incoming calls section
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Settings screen
    Then Settings screen is displayed
    Given INCOMING CALLS section is displayed on Settings screen
    And Call Forwarding settings item is displayed
    When user clicks Call Forwarding settings item
    Then Call Forwarding page is displayed
    And Choose extension for which you want to update the call forwarding numbers page description text is displayed
    And all extensions are displayed on Call Forwarding page
#    When user adds new forwarding number for <extension> extension
#    Then counter of Forwarding numbers has been increased
    When user edits forwarding number for <extension> extension
    And unchecks/checks forwarding number
    And deletes forwarding number for <extension>  extension
    Then counter of Forwarding numbers is unchanged
    Examples:
      | extension |
      | Ext 0     |
      | Ext 1     |
