package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DefaultUser;
import helper.NavigationTab;
import helper.Number;
import org.junit.Assert;

public class CallSteps extends BaseSteps {

    @Then("^each item from Call dropdown can be selected$")
    public void eachItemFromCallDropdownCanBeSelected() throws Throwable {
        for (Number value: DefaultUser.numbers)
        {
            app.callPage().setDropdownValue(value.number);

            // todo: need to add constants class
            Thread.sleep(3000);

            Assert.assertTrue(app.recentPage().getSelectedDropdownValue().equalsIgnoreCase(value.number));

            // todo: verify the list of actual elements
        }
    }
}
