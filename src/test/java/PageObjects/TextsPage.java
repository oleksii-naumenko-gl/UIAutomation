package PageObjects;

import helper.Helper;
import helper.SharedData;
import helper.TextsEntry;
import helper.enums;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TextsPage extends BaseHistoryPage{

    public TextsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tabs")
    private MobileElement tabsParent;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/texts_list")
    private MobileElement textsParent;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/swipe_done")
    private MobileElement swipeDoneButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/new_chat")
    private MobileElement startConversationButton;

    @AndroidFindBy(id="com.grasshopper.dialer:id/swipe_as_read")
    private MobileElement swipeUnreadReadButton;


    private String textEntryId = "com.grasshopper.dialer:id/swipe";

    public void openTab(enums.TextTabs tab){

        List<MobileElement> tabs = tabsParent.findElements(By.className("android.support.v7.app.ActionBar$Tab"));

        switch (tab) {
            case ALL:
                tabs.get(0).click();
                break;
            case DONE:
                tabs.get(1).click();
                break;
        }
    }


    // todo: add scrolling
    public void refreshHistory(){
        SharedData.textsMap.clear();

        List<MobileElement> elementList = textsParent.findElements(By.id(textEntryId));

        if (elementList.size() != 0){

            for (MobileElement element : elementList){
                TextsEntry entry = new TextsEntry(element);
                SharedData.textsMap.add(entry);
            }
        }
        else
        {
            logger.debug("No Texts entries present at the moment");
        }
    }

    public void markMessageAsDone(MobileElement element){
        swipeLeftfromObject(element, 3000);

        swipeDoneButton.click();
    }

    public void markMessageAsUnread(MobileElement element){
        swipeRightFromObject(element);
        swipeUnreadReadButton.click();
    }

    /**
     * Starts new conversation
     */
    public void startNewConversation(){
        startConversationButton.click();
    }

    /**
     * Searches for the texts entry based on Contact Name. Returns null if there are no such dialog present.
     * @return
     */
    public TextsEntry findEntryByContactName(String contactName){

        for (TextsEntry entry : SharedData.textsMap){
            if (entry.contact.equalsIgnoreCase(contactName))
            {
                return entry;
            }
        }

        return null;
    }
    public Boolean isConversationPresent(String contactName){
        Boolean isPresent = false;
        if (findEntryByContactName(contactName)!=null){
            isPresent = true;
        }
        return isPresent;
    }

    public void createContactForEntry(TextsEntry entry, String contactName){
        addToContacts(entry.mobileElement);
    }

    public void editContactForEntry(TextsEntry entry){
        createContactForEntry(entry, "");
    }

    public void updateUnreadDropdownCounters(){
        SharedData.textDropdownUnreadCounter.clear();

        openDropdownMenu();

        for (MobileElement element : getDropboxItems()){

            String number = element.findElement(By.id("android:id/text1")).getText();

            int counter = Helper.getUnreadDropdownCounter(element.findElement(By.id("com.grasshopper.dialer:id/count")).getText());

            SharedData.textDropdownUnreadCounter.put(number, counter);
        }

        // closing
        navigateBack();
    }

    public int getUnreadDropdownCounterForNumber(String number){
        updateUnreadDropdownCounters();

        return SharedData.textDropdownUnreadCounter.get(number);
    }

    /**
     * Getting the list of elements that represent parents of each line in the dropdown menu.
     * @return
     */
    private List<MobileElement> getDropboxItems() {
        return driver.findElements(By.className("android.widget.RelativeLayout"));
    }

}