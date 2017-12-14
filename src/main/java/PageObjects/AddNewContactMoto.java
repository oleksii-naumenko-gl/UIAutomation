package PageObjects;


import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class AddNewContactMoto extends BasePage {
    public AddNewContactMoto(AppiumDriver driver) {
        super(driver);
    }

    private String textFieldId = "com.android.contacts:id/editors";

    @AndroidFindBy(id = "com.android.contacts:id/kind_section_views")
    private MobileElement textFieldsParent;

    @AndroidFindBy(id = "com.android.contacts:id/menu_save")
    private MobileElement saveButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"More options\")")
    private MobileElement moreButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Delete\")")
    private MobileElement moreDeleteButton;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement deleteContactDialogDeleteButton;

    public void saveContact(){
        saveButton.click();
    }

    public void enterContactName(String name){
        List<MobileElement> textFields = textFieldsParent.findElements(By.id(textFieldId));

        textFields.get(0).sendKeys(name);

        driver.hideKeyboard();
    }

    public void deleteContact(){
        moreButton.click();
        moreDeleteButton.click();
        deleteContactDialogDeleteButton.click();
    }

}
