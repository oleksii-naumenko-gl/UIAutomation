@login
Feature: Login

  Scenario Outline: Verify Logging In with invalid credentials
    Given Grasshopper is installed on a clean device
    And user logs with invalid credentials <login> and <password>
    Then alert message <alert> is displayed

    Examples:
      | login                           |   password                                         | alert               |
      | login                           |   password                                         |   Sign In Failed    |


