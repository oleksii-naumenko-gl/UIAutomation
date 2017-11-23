package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.Then;
import helper.*;
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

}
