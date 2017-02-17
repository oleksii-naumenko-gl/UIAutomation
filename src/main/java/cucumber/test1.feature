Feature: Grasshopper Smoke Test

    Scenario Outline: Verify Logging In
      Given Grasshopper is installed on a clean device
      And user logs in with <login> and <password>
#      When the user clicks Submit
#      Then something bad will happen eventually


      Examples:
      | login                       | password            |
      | oleksii                     | abc123              |