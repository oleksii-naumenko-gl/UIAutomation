package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.Then;
import helper.DefaultUser;
import helper.Number;
import org.junit.Assert;

public class TextsSteps extends BaseSteps {

    @Then("^each item from Texts dropdown can be selected$")
    public void eachItemFromTextsDropdownCanBeSelected() throws Throwable {

        for (Number value: DefaultUser.numbers)
        {
            if (value.isSmsEnabled) {
                app.textsPage().setDropdownValue(value.number);

                // todo: need to add constants class
                Thread.sleep(3000);
                Assert.assertTrue(app.recentPage().getSelectedDropdownValue().equalsIgnoreCase(value.number));

                // todo: verify the list of actual elements
            }
        }
    }
}