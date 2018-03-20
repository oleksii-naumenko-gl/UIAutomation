package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.MyDriver;
import helper.AppiumFactory;
import helper.SharedData;

import java.net.MalformedURLException;

public class Hooks extends BaseSteps{

    @Before(value = "~@web")
    public void beforeScenario(){
        AppiumFactory.startAppium();
        app = GrasshopperApp.getInstance();
    }

    @After(value = "~@web")
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            app.embedScreenshot(scenario);
        }
        app.endSession();
        AppiumFactory.stopAppium();
    }


    @After(value = "@web")
    public void endSession() {
        MyDriver.getMyDriver().quit();

    }
}
