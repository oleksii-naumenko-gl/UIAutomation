package PageObjects;

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

    private String recentMapContact = "com.grasshopper.dialer:id/from";

    private String recentMapTimestamp = "com.grasshopper.dialer:id/received_time";

    private String recentMapExtension = "com.grasshopper.dialer:id/extension_info";

    private String detailsId = "com.grasshopper.dialer:id/info";

    @AndroidFindBy(id = "com.grasshopper.dialer:id/inbox_list")
    private MobileElement historyParent;

    public InboxPage(AppiumDriver driver) {
        super(driver);
    }

    public RecentInboxEntry getFirstEntry(){
        Map.Entry<RecentInboxEntry, MobileElement> entry = SharedData.inboxMap.entrySet().iterator().next();
        return entry.getKey();
    }

    public void refreshHistory(){
        SharedData.inboxMap.clear();

        List<MobileElement> elementList = historyParent.findElements(By.id(recentEntryId));

        if (elementList.size() != 0){

            for (MobileElement element : elementList){

                try {
                    RecentInboxEntry entry = new RecentInboxEntry(element.findElement(By.id(recentMapContact)).getText(),
                            element.findElement(By.id(recentMapTimestamp)).getText(),
                            element.findElement(By.id(recentMapExtension)).getText());
                    SharedData.inboxMap.put(entry, element);
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

}
