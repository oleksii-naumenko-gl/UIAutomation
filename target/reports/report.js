$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Calls/Calls1_CallFromDialer.feature");
formatter.feature({
  "line": 2,
  "name": "Grasshopper Smoke Test",
  "description": "",
  "id": "grasshopper-smoke-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@calls"
    }
  ]
});
formatter.before({
  "duration": 18479963977,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify Calling from Dialer",
  "description": "",
  "id": "grasshopper-smoke-test;verify-calling-from-dialer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Grasshopper is installed on a clean device",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user logs in with default credentials",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user navigates to Call screen",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user is able to perform call from dialer",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.grasshopperIsInstalledOnACleanDevice()"
});
formatter.result({
  "duration": 72859741,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.userLogsInWithDefaultCredentials()"
});
