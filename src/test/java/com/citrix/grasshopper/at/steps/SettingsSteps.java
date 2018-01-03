package com.citrix.grasshopper.at.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DefaultUser;
import helper.Extension;
import helper.SettingsItem;
import helper.SharedData;
import org.junit.Assert;

import java.util.Arrays;


public class SettingsSteps extends BaseSteps {
    private int counterBeforeAddingNewNumber;
    private int counterAfterAddingNewNumbers;

    @Then("^Settings page is displayed$")
    public void settingsPageIsDisplayed() {
        Assert.assertTrue("Verify Settings page is displayed ", app.settingsScreen().getScreenNameFromTopBar().equalsIgnoreCase("Settings"));
        Assert.assertTrue("Verify Sign out button is displayed ", app.settingsScreen().isSignOutButtonPresent());
        Assert.assertTrue("Verify Sign out button text ", app.settingsScreen().getSignOutButtonText().equalsIgnoreCase("Sign Out"));
        Assert.assertTrue("Verify numberLabel is displayed ", app.settingsScreen().getNumberLabel().equalsIgnoreCase("Your Number is: "));
        Assert.assertTrue("Verify your loginName is displayed ", app.settingsScreen().getUserNameText().equalsIgnoreCase(DefaultUser.login));
        Assert.assertTrue("Verify your GH Number is displayed ", app.settingsScreen().getUserNumberText().equalsIgnoreCase(String.valueOf(DefaultUser.numbers.toString().charAt(0))));
    }

    @Given("^(.*) section is displayed on Settings screen$")
    public void incomingCallsIsDisplayed(String sectionTitle) {
        Assert.assertTrue("Verify " + sectionTitle + " is displayed ", app.settingsScreen().getIncomingCallsSectionTitle().equalsIgnoreCase(sectionTitle));
    }

    @And("^Call Forwarding settings item is displayed$")

    public void callForwardingSettingsItemIsDisplayed() {
        Assert.assertTrue("Verify Call Forwarding settings item is displayed ", app.settingsScreen().getCallForwardingSettingsItemTitle().equalsIgnoreCase("Call Forwarding"));
        Assert.assertTrue("Verify Call Forwarding settings item subtext is displayed", app.settingsScreen().getCallForwardingSettingsItemSubtext().equalsIgnoreCase("Call Forwarding Numbers"));
        Assert.assertTrue("Verify navigation arrow is present ", app.settingsScreen().isCallForwardingSettingsNavigationArrowPresent());
    }

    @When("^user clicks (.*) settings item$")
    public void selectSettingsItem(String itemName) {
        app.settingsScreen().selectSettingsItem(itemName);
    }

    @Then("^Call Forwarding page is displayed$")
    public void callForwardingPageIsDisplayed(String pageTitle) {
        Assert.assertTrue("Verify " + pageTitle + "page  is displayed ", app.callForwardingSettingsPage().getTextFromPageTitle().equalsIgnoreCase(pageTitle));
        Assert.assertTrue("Verify backButton is present ", app.callForwardingSettingsPage().isBackButtonDisplayed());
    }

    @And("^(.*) page description text is displayed$")
    public void pageDescriptionIsDisplayed(String pageDescription) {
        Assert.assertTrue(app.callForwardingSettingsPage().getTextFromPageDescription().equalsIgnoreCase(pageDescription));
    }

    @And("^all extensions are displayed on Call Forwarding page$")
    public void allExtensionAreDisplayed() {
        Assert.assertTrue(app.callForwardingSettingsPage().getAllAvailableExtensions().equals(Arrays.asList(DefaultUser.extensions)));
    }

    //    @When("^user adds new forwarding number for (.*) extension$")
    public void addNewForwardingNumber(String extDescription) throws Exception {
        counterBeforeAddingNewNumber = app.callForwardingSettingsPage().getCounterOfForwardingNumbers(extDescription);
        app.callForwardingSettingsPage().clickExtentionStatusButton(extDescription);
        String extName = Extension.getExtensionName(extDescription);
        Assert.assertTrue("Verify " + extName + "page  is displayed ", app.callForwardingNumbersPage().getTextFromPageTitle().equalsIgnoreCase(extName));
        Assert.assertTrue("Verify backButton is present ", app.callForwardingNumbersPage().isBackButtonDisplayed());
        Assert.assertTrue(app.callForwardingNumbersPage().isIconToAddDisplayed());
        app.callForwardingNumbersPage().clickIconToAdd();
        app.newDestinationPage().enterPhone(DefaultUser.forwardingNumber);
        app.newDestinationPage().clickSaveButton();
        app.callForwardingNumbersPage().clickBack();
        counterAfterAddingNewNumbers = app.callForwardingSettingsPage().getCounterOfForwardingNumbers(extDescription);
    }

    //    @Then("^counter of Forwarding numbers has been increased$")
    public void verifyForwardingNumberCounterAfterAddingNumber() {
        Assert.assertTrue(counterAfterAddingNewNumbers == counterBeforeAddingNewNumber + 1);
    }

    @When("^user edits forwarding number for (.*) extension$")
    public void editForwardingNumber(String extDescription) {
        app.callForwardingSettingsPage().clickExtentionStatusButton(extDescription);
        app.callForwardingNumbersPage().refreshForwardingNumbersPage();
        app.callForwardingNumbersPage().clickForwardingNumber(DefaultUser.forwardingNumberAfterEditing);
        app.editDestinationPage().editNumber(DefaultUser.forwardingNumberAfterEditing);
    }

    @And("^unchecks/checks forwarding number$")
    public void uncheckCheckForwardingNumber() {
        app.callForwardingNumbersPage().refreshForwardingNumbersPage();
        app.callForwardingNumbersPage().clickForwardingNumberCheckbox(DefaultUser.forwardingNumberAfterEditing);

    }

    @And("^deletes forwarding number for (.*) extension$")
    public void deleteForwardingNumber(String extDescription) {

        app.callForwardingNumbersPage().clickForwardingNumber(DefaultUser.forwardingNumberAfterEditing);
        app.editDestinationPage().clickDelete();

        //           pop-up;
        app.callForwardingNumbersPage().clickBack();
        counterAfterAddingNewNumbers = app.callForwardingSettingsPage().getCounterOfForwardingNumbers(extDescription);

    }

    @Then("counter of Forwarding numbers is unchanged$")
    public void verifyForwardingNumberCounter() {
        Assert.assertTrue(counterBeforeAddingNewNumber == counterAfterAddingNewNumbers);
    }


    @Then("^Access Number page is displayed$")
    public void accessNumberPageIsDisplayed() {
        Assert.assertTrue("Verify page title on Access Number page", app.accessNumberPage().getTextFromPageTitle().equalsIgnoreCase("Access Number"));
        Assert.assertTrue(app.accessNumberPage().getPageDescriptionText().equalsIgnoreCase(app.accessNumberPage().PAGE_DESCRIPTION_TEXT));
    }

    @And("^Use plus one while dialing option can be switched$")
    public void usePlusOneWhileDialingOptionCanBeSwitched() {
        Assert.assertTrue("Verify Use +1 while dialing option is turned ON by default", app.accessNumberPage().isSwitchTurnedOn());
        app.accessNumberPage().switchUsePlusOneWhileDialing();
        Assert.assertTrue("Verify Use +1 while dialing option is turned OFF", !app.accessNumberPage().isSwitchTurnedOn());
        app.accessNumberPage().navigateBack();
        selectSettingsItem("Access Number");
        Assert.assertTrue("Verify Use +1 while dialing option is turned OFF after page refresh", !app.accessNumberPage().isSwitchTurnedOn());
        app.accessNumberPage().switchUsePlusOneWhileDialing();
        Assert.assertTrue("Verify Use +1 while dialing option is turned ON", app.accessNumberPage().isSwitchTurnedOn());
        app.accessNumberPage().navigateBack();
        selectSettingsItem("Access Number");
        Assert.assertTrue("Verify Use +1 while dialing option is turned ON", app.accessNumberPage().isSwitchTurnedOn());
    }

    @And("^each access number option can be selected$")
    public void eachAccessNumberOptionCanBeSelected() {
        String[] optionNamesArray = app.accessNumberPage().ACCESS_NUMBER_OPIONS;
        String defaultAccessNumberOption = optionNamesArray[0];
        app.accessNumberPage().refreshAccessNumberPage();
        Assert.assertTrue("Verify " + defaultAccessNumberOption + " option is selected by default", app.accessNumberPage().isAccessNumberOptionSelected(defaultAccessNumberOption));
        for (int index = 1; index < app.accessNumberPage().ACCESS_NUMBER_OPIONS.length; index++) {
            app.accessNumberPage().clickAccessNumberOption(optionNamesArray[index]);
            app.accessNumberPage().navigateBack();
            selectSettingsItem("Access Number");
            app.accessNumberPage().refreshAccessNumberPage();
            Assert.assertTrue("Verify " + optionNamesArray[index] + " option can be selected", app.accessNumberPage().isAccessNumberOptionSelected(optionNamesArray[index]));
        }
    }

    @Then("^Making Calls page is displayed$")
    public void makingCallsPageIsDisplayed() {
        Assert.assertTrue("Verify page title on Access Number page", app.makingCallsPage().getTextFromPageTitle().equalsIgnoreCase(app.makingCallsPage().PAGE_TITLE_TEXT));
    }

    @And("^each making calls option can be selected$")
    public void eachMakingCallsOptionCanBeSelected() {
        String[] optionNamesArray = app.makingCallsPage().MAKING_CALLS_OPTIONS;
        String defaultMakingCallsOption = optionNamesArray[0];
        app.makingCallsPage().refreshMakingCallsPage();
        Assert.assertTrue("Verify " + defaultMakingCallsOption + " option is selected by default", app.makingCallsPage().isMakingCallsOptionSelected(defaultMakingCallsOption));
        for (int index = 1; index < app.makingCallsPage().MAKING_CALLS_OPTIONS.length; index++) {
            app.makingCallsPage().clickMakingCallsOption(optionNamesArray[index]);
            app.makingCallsPage().navigateBack();
            selectSettingsItem("Making Calls");
            app.makingCallsPage().refreshMakingCallsPage();
            Assert.assertTrue("Verify " + optionNamesArray[index] + " option can be selected", app.makingCallsPage().isMakingCallsOptionSelected(optionNamesArray[index]));
        }
    }

    @Then("^My Extension page is displayed$")
    public void myExtensionPageIsDisplayed() {
        Assert.assertTrue("Verify page title on My Extension page", app.myExtensionPage().getTextFromPageTitle().equalsIgnoreCase(app.myExtensionPage().PAGE_TITLE_TEXT));
    }

    @And("^each Extension can be selected$")
    public void eachExtensionCanBeSelected() {
        app.myExtensionPage().refreshMyExtensionsSettingsList();
        for (int index = 0; index < SharedData.myExtensionSettingsList.size(); index++) {
            app.myExtensionPage().scrollUntilText((SharedData.myExtensionSettingsList.get(index)).getExtNumber());
            app.myExtensionPage().clickExtension((SharedData.myExtensionSettingsList.get(index)).getExtNumber());
            Assert.assertTrue(app.settingsScreen().getMainExtensionDescription().equalsIgnoreCase(SharedData.myExtensionSettingsList.get(index).getExtNumber()));
            selectSettingsItem("My Extension");
        }
    }

    @And("^Caller Info switch can be turned ON/OFF$")
    public void callerInfoSwitchCanBeTurnedONOFF() {
        app.settingsScreen().scrollUntilText(SettingsItem.CALLER_INFO.getText());
        Assert.assertFalse("Verify Caller Info is turned OFF by default", app.settingsScreen().isCallerInfoTurnedOn());
        app.settingsScreen().toggleCallerInfoSwitch();
        Assert.assertTrue("Verify Caller Info is turned ON", app.settingsScreen().isCallerInfoTurnedOn());
        app.settingsScreen().toggleCallerInfoSwitch();
        Assert.assertFalse("Verify Caller Info is turned OFF", app.settingsScreen().isCallerInfoTurnedOn());
    }
}
