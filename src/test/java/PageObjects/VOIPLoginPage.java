package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VOIPLoginPage extends BasePage {
    public VOIPLoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/wifi_promo_use_wifi")
    private MobileElement acceptWifiCalls;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/maybe_later")
    private MobileElement declineWifiCalls;

    public void acceptWifiCalls(){
        acceptWifiCalls.click();
    }

    public void declineWifiCalls(){
        declineWifiCalls.click();
    }

    public boolean isWifiDialogPresent(){

        boolean isPresent = false;

        try {
            isPresent = acceptWifiCalls.isDisplayed();
        }
        catch (Exception x){

        }

        return isPresent;
    }
}
