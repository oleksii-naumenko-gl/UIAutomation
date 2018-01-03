package PageObjects;

import helper.Helper;
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

    @AndroidFindBy(id = "com.grasshopper.dialer:id/dialer_key_start_call")
    private MobileElement callButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/dialer_key_favorites")
    private MobileElement favoritesButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/dialer_key_contacts")
    private MobileElement contactsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Paste\")")
    private MobileElement pasteButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/gv_keypad")
    private MobileElement keypadParent;

    public void enterPhoneNumber(String number) throws InterruptedException {
        logger.debug("Entering " + number + " number.");

        number = Helper.modifyFormattedNumber(number);

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

    public void openContacts(){
        logger.debug("Clicking Contacts button");
        contactsButton.click();
    }
}
