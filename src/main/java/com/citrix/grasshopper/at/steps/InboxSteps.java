package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.*;
import org.junit.Assert;

public class InboxSteps extends BaseSteps {

    private RecentInboxEntry entry;

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

        app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);

        app.inboxPage().openEntityDetails(app.inboxPage().getFirstEntry().mobileElement);
    }

    @Then("^new Inbox entry from (.*) is displayed with (.*)$")
    public void newInboxEntryFromFromNumberIsDisplayedWithToNumber(String fromNumber, String toNumber) throws Throwable {
        app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);

        RecentInboxEntry recentInboxEntry = app.inboxPage().getFirstEntry();

        Assert.assertTrue("Verify new Voicemail is displayed with a blue dot", recentInboxEntry.isUnread);
        Assert.assertTrue("Verify From number is correct", recentInboxEntry.contact.equalsIgnoreCase(fromNumber));
    }

    @And("^opens any new Inbox entry$")
    public void opensAnyNewInboxEntry() throws Throwable {
         app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);

        for (RecentInboxEntry inboxEntry : SharedData.inboxMap){

            if (inboxEntry.isUnread){
                entry = inboxEntry;
            }
        }

        if (entry == null){

            app.bottomNavigationBar().selectTab(NavigationTab.CALL);
            app.callPage().setDropdownValue(DefaultUser.numbers[0].number);
            app.callPage().enterPhoneNumber(Helper.modifyFormattedNumber(DefaultUser.numbers[1].number));
            app.callPage().clickCall();
            app.wifiCallPage().leaveVoicemail();
            app.bottomNavigationBar().selectTab(NavigationTab.INBOX);
            app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);
            app.inboxPage().updateUnreadCounters();

            entry = app.inboxPage().getFirstEntry();
        }

        entry.openDetails();

        // todo: replace with waiting for control to disappear
        Thread.sleep(20000);
    }

    @Then("^Voicemail details are shown$")
    public void voicemailDetailsAreShown() throws Throwable {
        Assert.assertTrue("Verify From number is displayed correctly", entry.contact.equalsIgnoreCase(
                app.voicemailDetails().getFromNumber()));
        Assert.assertFalse("Verify To number is displayed correctly",
                app.voicemailDetails().getToNumber().equalsIgnoreCase( ""));
        Assert.assertFalse("Verify Timestamp is displayed correctly",
                app.voicemailDetails().getTimestamp().equalsIgnoreCase( ""));
        Assert.assertFalse("Verify Message is displayed correctly",
                app.voicemailDetails().getMessage().equalsIgnoreCase( ""));

        app.voicemailDetails().navigateBack();
    }

    @And("^blue dot is removed from that entry$")
    public void blueDotIsRemovedFromThatEntry() throws Throwable {
        app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);
    }

    @And("^deletes first Inbox entry$")
    public void deletesFirstInboxEntry() throws Throwable {
        app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);
        app.inboxPage().setDropdownValue(InboxDropdownValue.DELETED.getText());
        app.inboxPage().refreshHistory(InboxDropdownValue.DELETED);

        app.inboxPage().setDropdownValue(InboxDropdownValue.INBOX.getText());

        // deleted entry
        entry = app.inboxPage().getFirstEntry();

        app.inboxPage().deleteEntry(entry);
        app.inboxPage().refreshHistory(InboxDropdownValue.INBOX);
    }

    @Then("^it is removed from the Inbox tab$")
    public void itIsRemovedFromTheInboxTab() throws Throwable {
        Assert.assertFalse("Verify deleted entry was removed from Inbox tab", entry.equals(app.inboxPage().getFirstEntry()));
    }

    @And("^is moved to Deleted tab$")
    public void isMovedToDeletedTab() throws Throwable {
        app.inboxPage().setDropdownValue(InboxDropdownValue.DELETED.getText());
        app.inboxPage().refreshHistory(InboxDropdownValue.DELETED);

        boolean flag = false;

        for (RecentInboxEntry deletedEntry : SharedData.deletedInboxMap)
        {
            if (deletedEntry.equals(entry)){flag = true;}
        }

        Assert.assertTrue("Verify entry was moved to deleted tab", flag);
    }
}
