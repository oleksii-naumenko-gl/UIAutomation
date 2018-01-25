@login @ios @debug
Feature: Grasshopper Smoke Test

  Scenario: Verify Logging In
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    Then Inbox page is displayed as Default

