package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.NavigationTab;
import org.junit.Assert;

public class BaseSteps {

    public static final GrasshopperApp app = GrasshopperApp.getInstance();

//    protected static WebDriver driver;
//    public static AppiumDriver<MobileElement> driver = app.setup();
//    public BaseSteps(AndroidDriver driver){
//        this.driver = driver;
//    }
//
//        @Before
//    public void beforeScenario() {
//              app = GrasshopperApp.getInstance();
//            driver = GrasshopperApp.setup();
//        System.out.println("this will run before the actual scenario");
//    }

    @When("^user navigates to (.*) screen$")
    public void navigateToTab(String tabName) {
        NavigationTab tab = getTabNameFromString(tabName);
        app.bottomNavigationBar().selectTab(tab);
    }

    @Then("^(.*) screen is displayed$")
    public void settingsScreenIsDisplayed(String tabName) throws Throwable {
        NavigationTab tab = getTabNameFromString(tabName);
        Assert.assertTrue(app.bottomNavigationBar().isTabSelected(tab));
    }

    public NavigationTab getTabNameFromString(String tabName) {
    NavigationTab tab;
    if (tabName.equalsIgnoreCase(NavigationTab.INBOX.getText())) {
        tab = NavigationTab.INBOX;
    } else if (tabName.equalsIgnoreCase(NavigationTab.SETTINGS.getText())) {
        tab = NavigationTab.SETTINGS;
    } else if (tabName.equalsIgnoreCase(NavigationTab.RECENT.getText())) {
        tab = NavigationTab.RECENT;
    } else if (tabName.equalsIgnoreCase(NavigationTab.CALL.getText())) {
        tab = NavigationTab.CALL;
    } else if (tabName.equalsIgnoreCase(NavigationTab.TEXTS.getText())) {
        tab = NavigationTab.TEXTS;
    } else {
        throw new IllegalArgumentException("Incorrect screen name");
    }

    return tab;
}

}
