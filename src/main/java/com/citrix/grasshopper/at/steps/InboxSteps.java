package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.InboxDropdownValue;
import helper.NavigationTab;
import helper.SharedData;
import org.junit.Assert;

public class InboxSteps extends BaseSteps {

    @Then("^Inbox page is displayed as Default$")
    public void inboxPageIsDisplayedAsDefault() throws Throwable {
        Assert.assertTrue(app.bottomNavigationBar().isTabSelected(NavigationTab.INBOX));
    }

    @Then("^each item from Inbox dropdown can be selected$")
    public void eachItemFromInboxDropdownCanBeSelected() throws Throwable {
        for (InboxDropdownValue value: InboxDropdownValue.values()
             ) {

            app.inboxPage().setDropdownValue(value.getText());
            Assert.assertTrue(app.inboxPage().getSelectedDropdownValue().equalsIgnoreCase(value.getText()));

            // todo: verify the list of actual elements
        }

    }

    @And("^opens first Voicemails details$")
    public void opensFirstVoicemailsDetails() throws Throwable {
        app.inboxPage().setDropdownValue(InboxDropdownValue.VOICEMAILS.getText());

        app.inboxPage().refreshHistory();

        app.inboxPage().openEntityDetails(SharedData.inboxMap.get(app.inboxPage().getFirstEntry()));
    }

}
