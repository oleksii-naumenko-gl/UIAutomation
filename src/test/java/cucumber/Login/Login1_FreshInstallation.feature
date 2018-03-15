@login
Feature: Login
@Android @login
  Scenario: Verify Logging In
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials
    Then Inbox page is displayed as Default

  @web
  Scenario: WEB Verify Logging In with valid credentials
    When user logs in with valid credentials
    Then Dialer web page is displayed as Default

