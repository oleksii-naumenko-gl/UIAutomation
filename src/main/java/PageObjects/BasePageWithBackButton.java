package PageObjects;


import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePageWithBackButton extends BasePage {
    public BasePageWithBackButton(AppiumDriver driver) {
        super(driver);
    }

    private MobileElement backButton = parentTopToolBar.findElementByClassName("android.widget.ImageButton");


    public void clickOnBackButton() {
        backButton.click();
    }

    public boolean isBackButtonDisplayed() {
        boolean isPresent = false;

        try {
            isPresent = backButton.isDisplayed();
        } catch (Exception x) {

            logger.error("Back button is not displayed on Call Forwarding Numbers page");
        }

        return isPresent;
    }
}
