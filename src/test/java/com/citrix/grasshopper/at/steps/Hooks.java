package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.AppiumFactory;
import helper.SharedData;

import java.net.MalformedURLException;

public class Hooks extends BaseSteps{

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        AppiumFactory.startAppium();

        SharedData.scenarioTags = scenario.getSourceTagNames();

        if (SharedData.scenarioTags.contains("@ios")){
            app = GrasshopperApp.getIosInstance();

        }
//
//        if (SharedData.scenarioTags.contains("@android")){
//            app = GrasshopperApp.getInstance();
//        }
//
//        if (SharedData.scenarioTags.contains("@browser")){
//            // TODO
//       }
    }

    @After
    public void afterScenarion(){
        app.endSession();
        AppiumFactory.stopAppium();

        if (SharedData.scenarioTags.contains("@browser")){
            // TODO
        }

    }

}
