package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class GetStartedPage extends BasePage {
    public GetStartedPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/phone_input")
    private MobileElement phoneInput;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/action_next")
    private MobileElement nextButton;

    public void enterPhone(String number){
        phoneInput.clear();

        phoneInput.sendKeys(number);
    }

    public void navigateNext(){
        nextButton.click();
    }


}
