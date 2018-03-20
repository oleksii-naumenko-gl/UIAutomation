
Feature: Login
  @login
  Scenario Outline: Verify Logging In with invalid credentials
    Given Grasshopper is installed on a clean device
    And user logs with invalid credentials <login> and <password>
    Then alert message <alert> is displayed

    Examples:
      | login | password | alert          |
      | login | password | Sign In Failed |

# Doesn't work in suite
  @web
  Scenario Outline:WEB Verify Logging In with invalid credentials
    When user logs in Webclient with invalid credentials <login> and <password>
    Then alert message is displayed on webpage

    Examples:
      | login | password |
      | login | password |

