package com.citrix.grasshopper.at.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;


public class Hooks extends BaseSteps {
    @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            app.embedScreenshot(scenario);
        }
    }
}
