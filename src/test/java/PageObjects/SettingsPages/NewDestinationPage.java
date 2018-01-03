package PageObjects.SettingsPages;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewDestinationPage extends BasePage {
    public NewDestinationPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement phoneInput;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/save")
    protected MobileElement saveButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/your_mobile_number")
    protected MobileElement inputFieldDescription;

    public void enterPhone(String number) {
        phoneInput.sendKeys(number);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
