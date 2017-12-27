package com.citrix.grasshopper.at.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Constants;
import helper.DefaultUser;
import org.junit.Assert;

public class LoginSteps extends BaseSteps{

    @Given("^Grasshopper is installed on a clean device$")
    public void grasshopperIsInstalledOnACleanDevice() throws Throwable {
    }

    @And("^user logs in with (.*) and (.*)$")
    public void userLogsInWithLoginAndPassword(String login, String password) throws Throwable {
        loginWithWifiOption(login, password, true);
    }

    @And("^user logs in with default credentials$")
    public void userLogsInWithDefaultCredentials() throws Throwable {
        userLogsInWithLoginAndPassword(DefaultUser.login, DefaultUser.password);
    }

    @And("^user logs with invalid credentials (.*) and (.*)$")
    public void userLogsInInvalidCredentials(String login, String password) throws Throwable {
        try{
            userLogsInWithLoginAndPassword(login, password);
        }
        catch (Exception x){
        }
    }

    @Then("^alert message (.*) is displayed$")
    public void loginErrorMessageErrorIsDisplayed(String errorMessage) throws Throwable {
        Assert.assertTrue("Verify sign in error is present", app.baseAlert().isAlertPresent());
        Assert.assertTrue("Verify sign in error message", app.baseAlert().getAlertTitle().equalsIgnoreCase(errorMessage));
    }

    @Then("^password error message (.*) is displayed$")
    public void passwordErrorMessageErrorIsDisplayed(String errorMessage) throws Throwable {
        Assert.assertTrue("Verify password error message is shown", app.loginPage().getLoginErrorMessage().equalsIgnoreCase(errorMessage));
    }

    @And("^user enters valid credentials$")
    public void userEntersValidCredentials() throws Throwable {
        app.loginPage().enterLogin(DefaultUser.login);
        app.loginPage().enterPassword(DefaultUser.password);
        app.loginPage().clickSignIn();

        app.baseDialog().waitUntilProgressDisappears();

        // allow to manage phone calls
        if (app.permissionRequest().isPermissionMessagePresent()){

            app.permissionRequest().allowAccess();
        }
    }

    @When("^user enters invalid cell phone number$")
    public void userEntersInvalidCellPhoneNumber() throws Throwable {
        app.getStartedPage().enterPhone(Constants.invalidAccessPoint);
        app.getStartedPage().navigateNext();
    }

    @Then("^invalid number error (.*) should be shown$")
    public void invalidNumberErrorShouldBeShown(String errorMessage) throws Throwable {
        Assert.assertTrue("Verify invalid number error is shown", app.getStartedPage().getInputErrorMessage().equalsIgnoreCase(errorMessage));
    }

    @And("^user logs in with default credentials with Wi-Fi turned off$")
    public void userLogsInWithDefaultCredentialsWithWiFiTurnedOff() throws Throwable {
        loginWithWifiOption(DefaultUser.login, DefaultUser.password, false);
    }

    private void loginWithWifiOption(String login, String password, boolean isWifi) throws InterruptedException {
        logger.info(String.format("Login user name -%s , password -%s", login, password));
        app.loginPage().enterLogin(login);
        app.loginPage().enterPassword(password);
        app.loginPage().clickSignIn();

        app.baseDialog().waitUntilProgressDisappears();

        // allow to manage phone calls
        if (app.permissionRequest().isPermissionMessagePresent()){
            app.permissionRequest().allowAccess();
        }

        // todo get user info from external source
        app.getStartedPage().enterPhone("6314524045");

        app.getStartedPage().navigateNext();

        // number confirmation
        if (app.baseAlert().isAlertPresent()){
            app.baseAlert().clickYes();
        }

        app.baseDialog().waitUntilProgressDisappears();

        app.extensionSelectionScreen().selectFirstExtension();

        app.baseDialog().waitUntilProgressDisappears();

        // Contacts access
        if (app.permissionRequest().isPermissionMessagePresent()){
            app.permissionRequest().allowAccess();
        }

        Thread.sleep(Constants.Timeouts.defaultActionTimeout);

        // Legal Disclamer
        app.loginPage().acceptLegalDisclaimer();

        // media access
        if (app.permissionRequest().isPermissionMessagePresent()){
            app.permissionRequest().allowAccess();
            app.permissionRequest().allowAccess();
        }

        // wifi goes here
        if (app.voipLoginPage().isWifiDialogPresent()){

            if (isWifi){
                app.voipLoginPage().acceptWifiCalls();
            }
            else
            {
                app.voipLoginPage().declineWifiCalls();
            }
        }

        // Cellular Data alert
        if (app.baseAlert().isAlertPresent()){
            app.baseAlert().clickYes();
        }

        // media access
        if (app.permissionRequest().isPermissionMessagePresent()){
            app.permissionRequest().allowAccess();
            app.permissionRequest().allowAccess();
        }

        // Removing all the tour banners
        // todo: tapping three times at the moment as there are no valid ids for these items.
        app.inboxPage().tapInTheMiddleOfTheScreen();
        app.inboxPage().tapInTheMiddleOfTheScreen();
        app.inboxPage().tapInTheMiddleOfTheScreen();
    }

    /**
     * Temporary method as there's no possibility to accept dialog.
     */
    private void acceptLegalDisclaimer(){
        app.loginPage().acceptLegalDisclaimer();

    }
}
