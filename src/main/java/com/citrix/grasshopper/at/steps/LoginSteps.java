package com.citrix.grasshopper.at.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helper.DefaultUser;

public class LoginSteps extends BaseSteps{

    @Given("^Grasshopper is installed on a clean device$")
    public void grasshopperIsInstalledOnACleanDevice() throws Throwable {
    }

    @And("^user logs in with (.*) and (.*)$")
    public void userLogsInWithLoginAndPassword(String login, String password) throws Throwable {

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

        // Legal Disclamer
        if (app.baseAlert().isAlertPresent()){
            app.baseAlert().clickYes();
        }

        // media access
        if (app.permissionRequest().isPermissionMessagePresent()){
            app.permissionRequest().allowAccess();
            app.permissionRequest().allowAccess();
        }

        // wifi goes here
        if (app.voipLoginPage().isWifiDialogPresent()){
            app.voipLoginPage().acceptWifiCalls();
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
        app.inboxPage().tapInTheMiddle();
        app.inboxPage().tapInTheMiddle();
        app.inboxPage().tapInTheMiddle();
    }

    @And("^user logs in with default credentials$")
    public void userLogsInWithDefaultCredentials() throws Throwable {
        userLogsInWithLoginAndPassword(DefaultUser.login, DefaultUser.password);
    }
}
