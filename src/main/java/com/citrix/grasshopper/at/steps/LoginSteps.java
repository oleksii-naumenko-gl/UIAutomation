package com.citrix.grasshopper.at.steps;

import PageObjects.ExtensionsLoginScreen;
import PageObjects.GetStartedPage;
import PageObjects.LoginPage;
import PageObjects.dialogs.BaseDialog;
import PageObjects.dialogs.NumberConfirmationDialog;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.deps.com.thoughtworks.xstream.core.util.ThreadSafePropertyEditor;
import cucumber.deps.com.thoughtworks.xstream.mapper.SystemAttributeAliasingMapper;

public class LoginSteps extends BaseSteps{

    private LoginPage page = new LoginPage(driverAppium);

    private BaseDialog dialog = new BaseDialog(driverAppium);

    private GetStartedPage startPage = new GetStartedPage(driverAppium);

    private ExtensionsLoginScreen extensionsLoginScreen = new ExtensionsLoginScreen(driverAppium);

    private NumberConfirmationDialog numberConfirmationDialog = new NumberConfirmationDialog(driverAppium);


    @Given("^Grasshopper is installed on a clean device$")
    public void grasshopperIsInstalledOnACleanDevice() throws Throwable {
            // empty step

//        page.enterLogin("oleksii");
//        page.enterPassword("boydivision");
//        page.clickSignIn();
    }

    @And("^user logs in with (.*) and (.*)$")
    public void userLogsInWithLoginAndPassword(String login, String password) throws Throwable {
        page.enterLogin(login);
        page.enterPassword(password);
        page.clickSignIn();

        dialog.waitUntilProgressDisappears();

        dialog.acceptDialog();

        startPage.enterPhone("6314524045");

        startPage.navigateNext();

        dialog.waitUntilProgressDisappears();

        numberConfirmationDialog.acceptDialog();

        dialog.waitUntilProgressDisappears();

        // extension

        extensionsLoginScreen.selectRandomExtension();

    }


}
