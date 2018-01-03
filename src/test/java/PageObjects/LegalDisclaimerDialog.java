package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LegalDisclaimerDialog extends BasePage {

    public LegalDisclaimerDialog(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;


    public void acceptDialog(){
        try {
            okButton.click();
        }
        catch (Exception x){

            x.getStackTrace();
            // dialog is not present
        }
    }

}
