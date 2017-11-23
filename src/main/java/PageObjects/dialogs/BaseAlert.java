package PageObjects.dialogs;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BaseAlert extends BasePage {
    public BaseAlert(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/alertTitle")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement yesButton;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/action_bar_root")
    private MobileElement alert;

    public boolean isAlertPresent(){

        boolean isPresent = false;

        try {
            isPresent = alert.isDisplayed();
        }
        catch (Exception x){

        }

        return isPresent;
    }

    public void clickYes(){
        yesButton.click();
    }

    public void clickNo(){
        noButton.click();
    }

    // TODO: add methods to get text fields

}
