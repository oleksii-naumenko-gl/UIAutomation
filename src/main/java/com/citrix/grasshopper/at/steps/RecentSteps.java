package com.citrix.grasshopper.at.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.*;
import helper.Number;
import org.junit.Assert;

public class RecentSteps extends BaseSteps{


    @Then("^each item from Recent dropdown can be selected$")
    public void eachItemFromRecentDropdownCanBeSelected() throws Throwable {

        for (RecentDropdownValue value: RecentDropdownValue.values())
        {
            app.recentPage().setDropdownValue(value.getText());
            Assert.assertTrue(app.recentPage().getSelectedDropdownValue().equalsIgnoreCase(value.getText()));

            // todo: verify the list of actual elements
        }
    }

    @When("^user navigates to Recent tab$")
    public void userNavigatesToRecentTab() throws Throwable {
        // TODO: remove, replace with Violetta's step

        app.recentPage().selectTab(NavigationTab.RECENT);
    }

}
