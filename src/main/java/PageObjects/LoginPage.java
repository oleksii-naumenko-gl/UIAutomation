package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;


public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.grasshopper.dialer:id/email_input")
    @iOSFindBy(id = "phone_input")
    private MobileElement loginUserId;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/password_input")
    @iOSFindBy(id = "password_input")
    private MobileElement loginPassword;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/sign_in")
    @iOSFindBy(id = "sign_in")
    private MobileElement loginSignIn;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterLogin(String text){
        loginUserId.click();

        loginUserId.sendKeys(text);
    }

    public void enterPassword(String text){
        loginPassword.click();

        loginPassword.sendKeys(text);
    }

    public void clickSignIn() throws InterruptedException {

        Thread.sleep(1000);

        loginSignIn.click();

    }


}
