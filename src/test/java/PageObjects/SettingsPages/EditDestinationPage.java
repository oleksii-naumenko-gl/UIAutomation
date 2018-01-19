package PageObjects.SettingsPages;

import helper.DefaultUser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;

public class EditDestinationPage extends NewDestinationPage {
    public EditDestinationPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/delete")
    private MobileElement deleteButton;

    @AndroidFindBy(id="com.grasshopper.dialer:id/save")
    private MobileElement saveButton;

    public void editNumber() {

        phoneInput.clear();
        phoneInput.sendKeys(DefaultUser.newForwardingNumber);

        clickSaveButton();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public void clickSave(){ saveButton.click();}
}