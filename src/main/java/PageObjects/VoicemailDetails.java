package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VoicemailDetails extends BasePage {
    public VoicemailDetails(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/messages_vm_callback")
    private MobileElement callbackButton;

    public void pressCallBack(){
        callbackButton.click();
    }

}
