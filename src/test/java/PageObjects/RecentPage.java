package PageObjects;

import helper.RecentInboxEntry;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class RecentPage extends BaseHistoryPage {

    private String recentEntryId = "com.grasshopper.dialer:id/swipe";

    private String recentMapContact = "com.grasshopper.dialer:id/from";

    private String recentMapTimestamp = "com.grasshopper.dialer:id/received_time";

    private String recentMapExtension = "com.grasshopper.dialer:id/extension_name";

    @AndroidFindBy(id = "com.grasshopper.dialer:id/history_list")
    private MobileElement historyParent;

    public RecentPage(AppiumDriver driver) {
        super(driver);
    }

    public void callByClickingEntry(RecentInboxEntry entry){
        SharedData.recentMap.get(entry).click();
    }

    public RecentInboxEntry getFirstEntry(){
        Map.Entry<RecentInboxEntry, MobileElement> entry = SharedData.recentMap.entrySet().iterator().next();
        return entry.getKey();
    }

    public void refreshHistory(){
        SharedData.recentMap.clear();

        List<MobileElement> elementList = historyParent.findElements(By.id(recentEntryId));

        if (elementList.size() != 0){

            for (MobileElement element : elementList){

                try {
                    RecentInboxEntry entry = new RecentInboxEntry(element);
                    SharedData.recentMap.put(entry, element);
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


}
