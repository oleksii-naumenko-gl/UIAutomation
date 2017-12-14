@DefaultValues
Feature: Grasshopper Smoke Test

  Scenario: Verify Recent Dropbox Default Values
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    When user navigates to Recent screen
    Then each item from Recent dropdown can be selected

