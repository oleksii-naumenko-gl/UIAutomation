Feature: Grasshopper Smoke Test

  Scenario: Verify Inbox Dropbox Default Values
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    Then each item from Inbox dropdown can be selected

