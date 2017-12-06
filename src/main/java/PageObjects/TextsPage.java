package PageObjects;

import helper.SharedData;
import helper.TextsEntry;
import helper.enums;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

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

    private String textFromId = "com.grasshopper.dialer:id/from";

    private String textMessageId = "com.grasshopper.dialer:id/message";

    private String textTimestampId = "com.grasshopper.dialer:id/received_time";

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

    public void refreshHistory(){
        SharedData.textsMap.clear();

        List<MobileElement> elementList = textsParent.findElements(By.id(textEntryId));

        if (elementList.size() != 0){

            for (MobileElement element : elementList){

                try {
                    TextsEntry entry = new TextsEntry(element.findElement(By.id(textFromId)).getText(),
                            element.findElement(By.id(textTimestampId)).getText(),
                            element.findElement(By.id(textMessageId)).getText());
                    SharedData.textsMap.put(entry, element);
                }
                catch (Exception x){
                    //todo: ADD SCROLLING
                    logger.debug("Element is not present");
                }
            }
        }
        else
        {
            logger.debug("No Texts entries present at the moment");
        }
    }

    public TextsEntry getFirstEntry(){
        Map.Entry<TextsEntry, MobileElement> entry = SharedData.textsMap.entrySet().iterator().next();
        return entry.getKey();
    }

    public void markMessageAsDone(MobileElement element){
        swipeLeftfromObject(element, 3000);

        swipeDoneButton.click();
    }

}
