$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/cucumber/Login/Login3_InvalidPhoneNumber.feature");
formatter.feature({
  "line": 2,
  "name": "Grasshopper Smoke Test",
  "description": "",
  "id": "grasshopper-smoke-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.before({
  "duration": 16817763999,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify Logging In with invalid phone number",
  "description": "",
  "id": "grasshopper-smoke-test;verify-logging-in-with-invalid-phone-number;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Grasshopper is installed on a clean device",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters valid credentials",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user enters invalid cell phone number",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "invalid number error The number you entered doesn\u0027t look valid. should be shown",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.grasshopperIsInstalledOnACleanDevice()"
});
formatter.result({
  "duration": 97770826,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.userEntersValidCredentials()"
});
formatter.result({
  "duration": 24408076269,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.userEntersInvalidCellPhoneNumber()"
});
formatter.result({
  "duration": 18806380816,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "The number you entered doesn\u0027t look valid.",
      "offset": 21
    }
  ],
  "location": "LoginSteps.invalidNumberErrorShouldBeShown(String)"
});
formatter.result({
  "duration": 2045642041,
  "status": "passed"
});
formatter.after({
  "duration": 2553542426,
  "status": "passed"
});
});