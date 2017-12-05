package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewDestinationPage extends BasePage {
    public NewDestinationPage(AppiumDriver driver) {
        super(driver);
    }

   // private MobileElement closeButtonOnTheTopToolBar = parentTopToolBar.findElementByClassName("android.widget.ImageButton");

    @AndroidFindBy(className="android.widget.EditText")
    private MobileElement phoneInput;

    @AndroidFindBy(id="com.grasshopper.dialer:id/save")
    private MobileElement saveButton;

    @AndroidFindBy(id="com.grasshopper.dialer:id/your_mobile_number")
    private  MobileElement inputFieldDescription;
    //todo remove to BasePage
    //private MobileElement pageTitle = parentTopToolBar.findElementByClassName("android.widget.TextView");


//  //  public String getTextFromPageTitle() {
//        return pageTitle.getText();
//    }

    public void enterPhone(String number){
//        phoneInput.clear();

        phoneInput.sendKeys(number);
    }
//    public void clickOnCloseButtonOnTheTopToolBar(){
//        closeButtonOnTheTopToolBar.click();
//    }

    public void clickSaveButton(){
        saveButton.click();
    }
}
