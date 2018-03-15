package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Base class for Inbox and Recent, that have the same element structure and ids.
 */
public class BaseHistoryPage extends BaseActionPage {
    public BaseHistoryPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/swipe_call")
    private MobileElement swipeCallButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/swipe_chat")
    private MobileElement swipeTextBackButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/swipe_more")
    private MobileElement swipeMoreButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/block_phone_number")
    private MobileElement moreAddToBlockedButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/modify_contact")
    private MobileElement moreAddContactButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/modify_contact")
    private MobileElement moreEditContactButton;

    public void openDetails(MobileElement element){

    }

    public void callBack(MobileElement element){
        swipeLeftfromObject(element, 3000);
        swipeCallButton.click();
    }

    public void textBack(MobileElement element){
        swipeLeftfromObject(element, 3000);

        swipeTextBackButton.click();
    }

    public void addToContacts(MobileElement element){
        swipeLeftfromObject(element, 3000);
        pressMore();
        moreAddContactButton.click();
    }

    public void editContact(MobileElement element){

    }

    public void addToBlockedNumbers(MobileElement element){

    }


    private void pressMore(){
        swipeMoreButton.click();
    }


}
