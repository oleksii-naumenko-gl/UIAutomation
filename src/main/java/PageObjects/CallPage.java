package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import java.util.List;

public class CallPage extends BaseActionPage {
    public CallPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/et_number_entry")
    private MobileElement numberInput;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/call_row")
    private MobileElement callButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/contacts")
    private MobileElement contactsButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/dialer_key_favorites")
    private MobileElement favoritesButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Paste\")")
    private MobileElement pasteButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/gv_keypad")
    private MobileElement keypadParent;

    public void enterPhoneNumber(String number) throws InterruptedException {
        logger.debug("Entering " + number + " number.");

        List<MobileElement> keys = keypadParent.findElements(By.id("com.grasshopper.dialer:id/tv_keypad_label"));

        for (char ch: number.toCharArray()) {

            for(MobileElement element : keys)
            {
                if (element.getText().equalsIgnoreCase(Character.toString(ch))){
                    logger.debug("Clicking " + ch + " button");
                    element.click();
                }
            }
        }

    }

    public void clickCall(){
        logger.debug("Clicking Call button");
        callButton.click();
    }

    public void openFavorites(){
        logger.debug("Clicking Favorites button");
        favoritesButton.click();
    }

}
