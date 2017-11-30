package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseSteps{

    @After
    public void afterScenarion(){
        app.endSession();
    }

    @Before
    public void beforeScenario(){
        app = GrasshopperApp.getInstance();
    }
}
