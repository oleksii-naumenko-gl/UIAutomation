@defaultValues
Feature: Default dropdown values

  Scenario: Verify Inbox Dropbox Default Values
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    Then each item from Inbox dropdown can be selected

