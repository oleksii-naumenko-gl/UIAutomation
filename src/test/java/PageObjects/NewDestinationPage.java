package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewDestinationPage extends BasePage {
    public NewDestinationPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement phoneInput;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/save")
    private MobileElement saveButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/your_mobile_number")
    private MobileElement inputFieldDescription;

    public void enterPhone(String number) {
        phoneInput.sendKeys(number);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
