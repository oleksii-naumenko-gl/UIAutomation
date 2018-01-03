@general
Feature: WiFi Calling Option

  Scenario: Verify turning Wi-Fi calls off during login
    Given Grasshopper is installed on a clean device
    And user logs in with default credentials with Wi-Fi turned off
    When user navigates to Call screen
    Then the call is performed via PSTN


