@dropbox
Feature: Default Dropbox Values

  Scenario: Verify Inbox Dropbox Default Values
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    Then each item from Inbox dropdown can be selected

  Scenario: Verify Recent Dropbox Default Values
    When user navigates to Recent screen
    Then each item from Recent dropdown can be selected

  @Important
  Scenario: Verify Call Dropbox Default Values
    When user navigates to Call screen
    Then each item from Call dropdown can be selected

  @Important
  Scenario: Verify Texts Dropbox Default Values
    #screenName with error
    When user navigates to Text screen
    Then each item from Texts dropdown can be selected