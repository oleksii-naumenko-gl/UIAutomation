package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.AppiumFactory;


public class Hooks extends BaseSteps {
//    @After
//    public void takeScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
//            app.embedScreenshot(scenario);
//        }
//    }
    @Before
    public static void beforeScenarios() {
        AppiumFactory.startAppium();
        app = GrasshopperApp.getInstance();
    }

    @After
    public static void afterScenarios() {
        app.endSession();
        AppiumFactory.stopAppium();

    }
}
