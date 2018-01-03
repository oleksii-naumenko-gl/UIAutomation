package PageObjects.SettingsPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditDestinationPage extends NewDestinationPage {
    public EditDestinationPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/delete")
    private MobileElement deleteButton;

    public void editNumber(String number) {
        // phoneInput.sendKeys(Keys.BACK_SPACE);
        phoneInput.clear();
        phoneInput.sendKeys(number);
        clickSaveButton();
    }

    public void clickDelete() {
        deleteButton.click();
    }
}