package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Extension;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static helper.DefaultUser.login;
import static helper.DefaultUser.numbers;
import  static helper.DefaultUser.extensions;


public class SettingsSteps extends BaseSteps {

    @Then("^Settings page is displayed$")
    public void settingsPageIsDisplayed() {
        Assert.assertTrue("Verify Settings page is displayed ", app.settingsScreen().getScreenNameFromTopBar().equalsIgnoreCase("Settings"));
        Assert.assertTrue("Verify Sign out button is displayed ", app.settingsScreen().isSignOutButtonPresent());
        Assert.assertTrue("Verify Sign out button text ", app.settingsScreen().getTextFromSignOutButton().equalsIgnoreCase("Sign Out"));
        Assert.assertTrue("Verify numberLabel is displayed ", app.settingsScreen().getTextFromNumberLabel().equalsIgnoreCase("Your Number is: "));
        Assert.assertTrue("Verify your loginName is displayed ", app.settingsScreen().getTextFromUserName().equalsIgnoreCase(login));
        Assert.assertTrue("Verify your GH Number is displayed ", app.settingsScreen().getTextFromUserNumber().equalsIgnoreCase(String.valueOf(numbers.toString().charAt(0))));

    }

    @Given("^(.*) section is displayed on Settings screen$")
    public void incomingCallsIsDisplayed(String sectionTitle) {
        Assert.assertTrue("Verify " + sectionTitle + " is displayed ", app.settingsScreen().getTextFromIncomingCallsSectionTitle().equalsIgnoreCase(sectionTitle));
    }

    @And("^Call Forwarding settings item is displayed$")

    public void callForwardingSettingsItemIsDisplayed() {
        Assert.assertTrue("Verify Call Forwarding settings item is displayed ", app.settingsScreen().getTextFromCallForwardingSettingsItemTitle().equalsIgnoreCase("Call Forwarding"));
        Assert.assertTrue("Verify Call Forwarding settings item subtext is displayed", app.settingsScreen().getTextFromCallForwardingSettingsItemSubtext().equalsIgnoreCase("Call Forwarding Numbers"));
        Assert.assertTrue("Verify navigation arrow is present ", app.settingsScreen().isCallForwardingSettingsNavigationArrowPresent());
    }


    @When("^user clicks on Call Forwarding$")
    public void clickOnCallForwardingItem() {
        app.settingsScreen().clickOnCallForwardingSettingsNavigationArrow();
    }

    @Then("^(.*) page is displayed$")
    public void pageIsDisplayed(String pageTitle) {
        Assert.assertTrue("Verify " + pageTitle + "page  is displayed ", app.callForwardingSettingsPage().getTextFromPageTitle().equalsIgnoreCase(pageTitle));
        Assert.assertTrue("Verify backButton is present ", app.callForwardingSettingsPage().isBackButtonDisplayed());


    }

    @And("^(.*) page description text is displayed$")
    public void pageDescriptionIsDisplayed(String pageDescription) {
        Assert.assertTrue(app.callForwardingSettingsPage().getTextFromPageDescription().equalsIgnoreCase(pageDescription));

    }
    @And("^print all available extensions$")
    public void printAllAvailableExtensions() throws InterruptedException {
        List<Extension> x = app.callForwardingSettingsPage().getAllAvailableExtensions();

        Thread.sleep(300);
    }
    @And ("^all extensions are displayed on Call Forwarding page$")
    public void allExtensionAreDisplayed(){
    Assert.assertTrue(app.callForwardingSettingsPage().getAllAvailableExtensions().equals(Arrays.asList(extensions)));

    }

}
