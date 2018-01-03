package com.citrix.grasshopper.at.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.*;
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
        app.callPage().enterPhoneNumber(Constants.incomingCall);

        app.callPage().clickCall();

        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());

        app.wifiCallPage().endCall();
    }

    @And("^opens Favorites screen$")
    public void opensFavoritesScreen() throws Throwable {
        app.callPage().openFavorites();
    }

    @And("^opens Contacts screen$")
    public void opensContactsScreen() throws Throwable {
        app.callPage().openContacts();
    }

    @Then("^user is able to perform call from the Contacts screen$")
    public void userIsAbleToPerformCallFromTheContactsScreen() throws Throwable {
        app.contactsPage().selectRandomContact();

        app.singleContactPage().callContact();

        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());
    }

    @Then("^user is able to perform call from the Recent screen by clicking an existing entry$")
    public void userIsAbleToPerformCallFromTheRecentScreenByClickingAnExistingEntry() throws Throwable {
        app.recentPage().refreshHistory();
        app.recentPage().callByClickingEntry(app.recentPage().getFirstEntry());

        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());
    }

    @Then("^user is able to perform call from the Recent screen by using swipe menu$")
    public void userIsAbleToPerformCallFromTheRecentScreenByUsingSwipeMenu() throws Throwable {
        app.recentPage().refreshHistory();

        app.recentPage().callBack(SharedData.recentMap.get(app.recentPage().getFirstEntry()));

        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());
    }

    @Then("^user is able to perform call from the Inbox screen by using swipe menu$")
    public void userIsAbleToPerformCallFromTheInboxScreenByUsingSwipeMenu() throws Throwable {
        app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);
        app.inboxPage().callBack(SharedData.inboxMap.get(0).mobileElement);
        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());
    }

    @Then("^user is able to perform call from the Voicemail details$")
    public void userIsAbleToPerformCallFromTheVoicemailDetails() throws Throwable {
        Thread.sleep(Constants.Timeouts.voicemailTimeout);
        app.voicemailDetails().pressCallBack();
        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());
    }

    @Then("^user is able to perform call from the Texts using swipe menu$")
    public void userIsAbleToPerformCallFromTheTextsUsingSwipeMenu() throws Throwable {
        app.textsPage().refreshHistory();

        app.textsPage().callBack(SharedData.textsMap.get(0).mobileElement);

        Assert.assertTrue("Verify Call is being performed", app.wifiCallPage().isWifiCallPresent());
    }

    @Then("^the call is performed via PSTN$")
    public void theCallIsPerformedViaPSTN() throws Throwable {
        app.callPage().enterPhoneNumber(Constants.incomingCall);

        app.callPage().clickCall();

        Assert.assertFalse("Verify Call is being performed via PSTN", app.wifiCallPage().isWifiCallPresent());
    }

    @And("^leaves new Voicemail from (.*) to (.*)$")
    public void leavesNewVoicemailFromFromNumberToToNumber(String fromNumber, String toNumber) throws Throwable {
        app.callPage().updateUnreadCounters();
        app.callPage().setDropdownValue(fromNumber);
        app.callPage().enterPhoneNumber(Helper.modifyFormattedNumber(toNumber));
        app.callPage().clickCall();
        app.wifiCallPage().leaveVoicemail();
    }
}