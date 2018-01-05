package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.AppiumFactory;

public class Hooks extends BaseSteps {

    @Before
    public void beforeScenario() {
        AppiumFactory.startAppium();
        app = GrasshopperApp.getInstance();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            app.embedScreenshot(scenario);
        }
        app.endSession();
        AppiumFactory.stopAppium();
    }

}
