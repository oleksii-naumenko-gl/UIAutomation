package PageObjects;

import helper.InboxDropdownValue;
import helper.RecentInboxEntry;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class InboxPage extends BaseHistoryPage{

    private String recentEntryId = "com.grasshopper.dialer:id/swipe";

    private String detailsId = "com.grasshopper.dialer:id/info";

    @AndroidFindBy(id = "com.grasshopper.dialer:id/inbox_list")
    private MobileElement historyParent;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/swipe_delete")
    private MobileElement swipeDeleteButton;

    public InboxPage(AppiumDriver driver) {
        super(driver);
    }

    public RecentInboxEntry getFirstEntry(){
        return SharedData.inboxMap.get(0);
    }

    public void refreshHistory(InboxDropdownValue selectedTab){

        if (selectedTab == InboxDropdownValue.INBOX){
            SharedData.inboxMap.clear();
        }
        if (selectedTab == InboxDropdownValue.DELETED){
            SharedData.deletedInboxMap.clear();
        }

        List<MobileElement> elementList = historyParent.findElements(By.id(recentEntryId));

        if (elementList.size() != 0){

            for (MobileElement element : elementList){

                try {
                    RecentInboxEntry entry = new RecentInboxEntry(element);


                    if (selectedTab == InboxDropdownValue.INBOX){
                        SharedData.inboxMap.add(entry);
                    }
                    if (selectedTab == InboxDropdownValue.DELETED){
                        SharedData.deletedInboxMap.add(entry);
                    }

                }
                catch (Exception x){
                    //todo: ADD SCROLLING
                    logger.debug("Element is not present");
                }
            }

        }
        else
        {
            logger.debug("No inbox entries present at the moment");
        }
    }

    public void openEntityDetails(MobileElement entry){
        entry.findElement(By.id(detailsId)).click();
    }

    public void updateUnreadDropdownCounters() {


    }

    public void deleteEntry(RecentInboxEntry entry){
        swipeLeftfromObject(entry.mobileElement, 3000);
        pressDeleteButton();
    }

    private void pressDeleteButton(){
        swipeDeleteButton.click();
    }
}
