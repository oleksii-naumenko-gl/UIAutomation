package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Extension;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import helper.DefaultUser;



public class SettingsSteps extends BaseSteps {

    @Then("^Settings page is displayed$")
    public void settingsPageIsDisplayed() {
        Assert.assertTrue("Verify Settings page is displayed ", app.settingsScreen().getScreenNameFromTopBar().equalsIgnoreCase("Settings"));
        Assert.assertTrue("Verify Sign out button is displayed ", app.settingsScreen().isSignOutButtonPresent());
        Assert.assertTrue("Verify Sign out button text ", app.settingsScreen().getTextFromSignOutButton().equalsIgnoreCase("Sign Out"));
        Assert.assertTrue("Verify numberLabel is displayed ", app.settingsScreen().getTextFromNumberLabel().equalsIgnoreCase("Your Number is: "));
        Assert.assertTrue("Verify your loginName is displayed ", app.settingsScreen().getTextFromUserName().equalsIgnoreCase(DefaultUser.login));
        Assert.assertTrue("Verify your GH Number is displayed ", app.settingsScreen().getTextFromUserNumber().equalsIgnoreCase(String.valueOf(DefaultUser.numbers.toString().charAt(0))));

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
        Assert.assertTrue(app.callForwardingSettingsPage().getAllAvailableExtensions().equals(Arrays.asList(DefaultUser.extensions)));
    }
    @When("^user adds new forwarding number for (.*) extension$")
public void addNewForwardingNumber(String extDescription) throws IOException {
        app.callForwardingSettingsPage().clickOnExtentionStatusButton(extDescription);
        String extName=Extension.getExtensionName(extDescription);
        Assert.assertTrue("Verify " + extName + "page  is displayed ", app.callForwardingNumbersPage().getTextFromPageTitle().equalsIgnoreCase(extName));
        Assert.assertTrue("Verify backButton is present ", app.callForwardingNumbersPage().isBackButtonDisplayed());
        Assert.assertTrue(app.callForwardingNumbersPage().isIconToAddDisplayed());
        app.callForwardingNumbersPage().clickOnIconToAdd();
        app.newDestinationPage().enterPhone(DefaultUser.forwardingNumber);
        app.newDestinationPage().clickSaveButton();
        app.callForwardingNumbersPage().clickOnBackButton();
    }
    @Then("^(.*) status is displayed for (.*) extension$")
    public void verifyForwardingStatusOfExtension(String status,String extDescription){
        app.callForwardingSettingsPage().getForwardingStatusOfExtension(extDescription).equalsIgnoreCase(status);
    }

}
