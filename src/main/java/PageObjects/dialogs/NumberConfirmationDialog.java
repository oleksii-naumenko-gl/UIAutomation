package PageObjects.dialogs;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * Created by admin on 2/21/17.
 */
public class NumberConfirmationDialog extends BasePage {
    public NumberConfirmationDialog(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/action_bar_root")
    private MobileElement dialog;

    @AndroidFindBy(id = "android:id/button1")
    @iOSFindBy(id = "phone_input") //tbd
    private MobileElement yesButton;

    @AndroidFindBy(id = "android:id/button2")
    @iOSFindBy(id = "phone_input") //tbd
    private MobileElement noButton;

    public boolean isDialogPresent(){
        return this.dialog.isDisplayed();
    }

    public void acceptDialog(){
        if (isDialogPresent()){
            yesButton.click();
        }
    }
}
