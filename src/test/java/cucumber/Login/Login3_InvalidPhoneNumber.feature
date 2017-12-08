@login
Feature: Grasshopper Smoke Test

  Scenario: Verify Logging In with invalid phone number
    Given Grasshopper is installed on a clean device
    And user enters valid credentials
    When user enters invalid cell phone number
    Then invalid number error message should be shown

