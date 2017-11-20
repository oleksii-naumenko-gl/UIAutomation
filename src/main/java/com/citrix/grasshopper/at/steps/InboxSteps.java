package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.Then;
import helper.NavigationTab;
import org.junit.Assert;

public class InboxSteps extends BaseSteps {

    @Then("^Inbox page is displayed as Default$")
    public void inboxPageIsDisplayedAsDefault() throws Throwable {
        Assert.assertTrue(app.bottomNavigationBar().isTabSelected(NavigationTab.INBOX));
    }
}
