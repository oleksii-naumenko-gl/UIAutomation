package com.citrix.grasshopper.at.steps;


import PageObjects.GrasshopperApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected static WebDriver driver;
    public static final GrasshopperApp app = GrasshopperApp.getInstance();
    public static AppiumDriver<MobileElement> driverAppium = GrasshopperApp.getInstance().getAndroidWebDriver();
//
//    @Before
//    public void beforeScenario() {
//        driverAppium = GrasshopperApp.getInstance().getAndroidWebDriver();
//        System.out.println("this will run before the actual scenario");
//    }



}
