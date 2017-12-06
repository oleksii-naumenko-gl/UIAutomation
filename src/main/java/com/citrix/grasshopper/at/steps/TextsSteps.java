package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DefaultUser;
import helper.Number;
import helper.SharedData;
import helper.enums;
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

    @When("^user opens (.*) tab on Texts$")
    public void userOpensDoneTabOnTexts(enums.TextTabs tab) throws Throwable {
        app.textsPage().openTab(tab);
    }

    @And("^checks there are messages marked as Done$")
    public void checksThereAreMessagesMarkedAsDone() throws Throwable {
        app.textsPage().refreshHistory();

        if (SharedData.textsMap.size() == 0){
            app.textsPage().openTab(enums.TextTabs.ALL);
            app.textsPage().refreshHistory();
            app.textsPage().markMessageAsDone(SharedData.textsMap.get(app.textsPage().getFirstEntry()));
            app.textsPage().openTab(enums.TextTabs.DONE);
            app.textsPage().refreshHistory();
        }
    }
}
