@Settings1_IncomingCalls
Feature: Settings screen

  Scenario: Verify Incoming calls section
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Settings screen
    Then Settings screen is displayed
    Given INCOMING CALLS section is displayed on Settings screen
    When user navigates to Settings screen
    And Call Forwarding settings item is displayed
    When user clicks on Call Forwarding
    Then Call Forwarding Settings page is displayed
    And Choose extension for which you want to update the call forwarding numbers page description text is displayed
    And all extensions are displayed on Call Forwarding page
    When user adds new forwarding number for Ext 0 extension
    Then counter of Forwarding numbers for extension has been changed







