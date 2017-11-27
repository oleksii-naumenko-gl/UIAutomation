package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CallForwardingSettingsPage extends BasePage {


    public CallForwardingSettingsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.LinearLayout")
    private MobileElement pageContainer;

    private MobileElement pageTitle = parentTopToolBar.findElementByClassName("android.widget.TextView");

    private MobileElement backButton = parentTopToolBar.findElementByClassName("android.widget.ImageButton");

    private MobileElement pageDescription = pageContainer.findElementsByClassName("android.widget.TextView").get(0);

    public String getTextFromPageTitle() {
        return pageTitle.getText();
    }

    public String getTextFromPageDescription() {
        return pageDescription.getText();
    }

    public boolean isBackButtonDisplayed() {

        boolean isPresent = false;

        try {
            isPresent = backButton.isDisplayed();
        } catch (Exception x) {

        }

        return isPresent;
    }
}
