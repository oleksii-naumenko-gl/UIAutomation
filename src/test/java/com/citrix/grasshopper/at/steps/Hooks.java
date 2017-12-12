package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import cucumber.api.Scenario;
import cucumber.api.java.After;



public class Hooks extends BaseSteps {
    //    @Before
    public void beforeScenario() {
        app = GrasshopperApp.getInstance();
    }

//    @After

    @After
    private void embedScreenshotIfScenarioIsFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            app.takeScreenshot(scenario);
        }
    }


    public void afterScenario() {
        app.endSession();
    }
}

