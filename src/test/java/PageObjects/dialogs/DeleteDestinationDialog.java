package PageObjects.dialogs;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class DeleteDestinationDialog extends BasePage {
    public DeleteDestinationDialog(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id="com.grasshopper.dialer:id/alertTitle")
    private MobileElement dialogTitlr;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement dialogMessage;

    @AndroidFindBy(id="android:id/button2")
    private MobileElement cancelButton;

    @AndroidFindBy(id="android:id/button1")
    private MobileElement deleteButton;

    public void clickCancel(){
        cancelButton.click();
    }

    public void clickDelete(){
        deleteButton.click();
    }

    public String getTitleText(){
       return dialogMessage.getText();
    }

    public String getMessagetext(){
        return dialogMessage.getText();
    }


}
