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

    @AndroidFindBy(id = "com.grasshopper.dialer:id/textinput_error")
    private MobileElement errorMessage;

    public static final String INVALID_NUMBER_ERROR_MESSAGE="The number you entered doesn't look valid.";
    public void enterPhone(String number){
        phoneInput.clear();

        phoneInput.sendKeys(number);
    }

    public String getInputErrorMessage(){
        try {
            return errorMessage.getText();
        }
        catch (Exception x){
        }

        return "Error is not present";
    }

    public void navigateNext(){
        nextButton.click();
    }

}
