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

    @AndroidFindBy(id = "com.grasshopper.dialer:id/vm_first_row_data")
    private MobileElement fromNumber;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/vm_third_row_data")
    private MobileElement toNumber;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/vm_fourth_row_data")
    private MobileElement timestamp;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/messages_vm_body")
    private MobileElement transcriptedMessage;

    public void pressCallBack(){
        callbackButton.click();
    }

    public String getFromNumber(){
        return fromNumber.getText();
    }

    public String getToNumber(){
        return toNumber.getText();
    }

    public String getTimestamp(){
        return timestamp.getText();
    }

    public String getMessage(){
        return transcriptedMessage.getText();
    }



}
