@login
Feature: Grasshopper Smoke Test

  Scenario Outline: Verify Logging In
    Given Grasshopper is installed on a clean device
    And user logs in with <login> and <password>
    Then Inbox page is displayed as Default


    Examples:
      | login                                    | password            |
      | oleksii.naumenko@logmein.com                      | abc123              |