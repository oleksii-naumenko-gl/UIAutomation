package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LoginSteps extends BaseSteps{

    @Given("^Grasshopper is installed on a clean device$")
    public void grasshopperIsInstalledOnACleanDevice() throws Throwable {
    }

    @And("^user logs in with (.*) and (.*)$")
    public void userLogsInWithLoginAndPassword(String login, String password) throws Throwable {

        app.loginPage().enterLogin(login);
        app.loginPage().enterPassword(password);
        app.loginPage().clickSignIn();

        // this can be moved to other page, maybe the base one
        app.baseDialog().waitUntilProgressDisappears();

        if (app.baseDialog().isDialogPresent()){

            app.baseDialog().acceptDialog();
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
        if (app.baseDialog().isDialogPresent()){

            app.baseDialog().acceptDialog();
        }

        app.baseDialog().waitUntilProgressDisappears();

        // Legal Disclamer
        if (app.baseAlert().isAlertPresent()){
            app.baseAlert().clickYes();
        }

        app.baseDialog().waitUntilProgressDisappears();

        // wifi goes here
        if (app.voipLoginPage().isWifiDialogPresent()){
            app.voipLoginPage().acceptWifiCalls();
        }

        app.baseDialog().waitUntilProgressDisappears();

        // Cellular Data alert
        if (app.baseAlert().isAlertPresent()){
            app.baseAlert().clickYes();
        }

        // Media access
        if (app.baseDialog().isDialogPresent()){

            app.baseDialog().acceptDialog();
        }

    }

}
