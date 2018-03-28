package PageObjects;

import PageObjects.base.BasePage;
import helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WifiCallPage extends BasePage {
    public WifiCallPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/outgoing_call_container")
    private MobileElement callContainer;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/iv_end_call")
    private MobileElement endCallButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_status_text")
    private MobileElement statusText;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/iv_mute_icon")
    private MobileElement muteIcon;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/iv_keypad_icon")
    private MobileElement dialIcon;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/iv_speaker_icon")
    private MobileElement speakerIcon;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/hold_button_icon")
    private MobileElement holdIcon;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/time_text")
    private MobileElement callTimeText;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/gv_keypad")
    private MobileElement dialpadParent;

    public boolean isWifiCallPresent(){

        boolean isPresent = false;

        try {
            isPresent = callContainer.isDisplayed();
        }
        catch (Exception x){

        }

        return isPresent;
    }

    public void endCall(){
        try {
            endCallButton.click();
        }
        catch (Exception x){
            logger.error("End call button is not present");
        }
    }

    public void openDialpad(){
        dialIcon.click();
    }

    public void waitUntilCallIsConnected(){
        try {
            (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(callTimeText));
        }
        catch (TimeoutException e)
        {
        }
    }

    public void enterPhoneNumber(String number) throws InterruptedException {
        logger.debug("Entering " + number + " number.");

        List<MobileElement> keys = dialpadParent.findElements(By.id("com.grasshopper.dialer:id/tv_keypad_label"));

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

    public void leaveVoicemail() throws InterruptedException {
        waitUntilCallIsConnected();
        openDialpad();
        Thread.sleep(3000);
        enterPhoneNumber("0");
        Thread.sleep(5000);
        enterPhoneNumber("*");
        Thread.sleep(10000);
        enterPhoneNumber("2");
        enterPhoneNumber("2");
        Thread.sleep(10000);
    }

}