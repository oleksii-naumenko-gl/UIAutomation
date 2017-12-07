package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

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

}
