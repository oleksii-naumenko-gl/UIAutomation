package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.Constants;
import helper.DefaultUser;
import helper.Number;
import org.junit.Assert;

public class CallSteps extends BaseSteps {

    @Then("^each item from Call dropdown can be selected$")
    public void eachItemFromCallDropdownCanBeSelected() throws Throwable {
        for (Number value: DefaultUser.numbers)
        {
            app.callPage().setDropdownValue(value.number);

            Thread.sleep(Constants.Timeouts.defaultActionTimeout);

            Assert.assertTrue(app.recentPage().getSelectedDropdownValue().equalsIgnoreCase(value.number));
        }
    }

    @Then("^user is able to perform call from dialer$")
    public void userIsAbleToPerformCallFromDialer() throws Throwable {
        app.callPage().enterPhoneNumber(Constants.smsOutgoingNumber);

        app.callPage().clickCall();

        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());

        app.wifiCallPage().endCall();
    }

    @And("^opens Favorites screen$")
    public void opensFavoritesScreen() throws Throwable {
        app.callPage().openFavorites();
    }

}
