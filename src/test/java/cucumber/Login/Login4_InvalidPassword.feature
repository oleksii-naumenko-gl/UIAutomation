@login
Feature: Grasshopper Smoke Test

  Scenario Outline: Verify Logging In with password that is too short
    Given Grasshopper is installed on a clean device
    And user logs with invalid credentials <login> and <password>
    Then password error message <error> is displayed

    Examples:
      | login                           |   password                                         | error                |
      | oleksii                         |   ab                                               |   Password too short |


