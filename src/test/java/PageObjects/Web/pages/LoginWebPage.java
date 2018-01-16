package PageObjects.Web.pages;

import PageObjects.base.BaseWebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginWebPage extends BaseWebPage {
    @FindBy(id = "user_id")
    private WebElement inputLogin;

    @FindBy(id = "user_password")
    private WebElement inputPassword;

    @FindBy(id = "login-btn")
    private WebElement sighInButton;

    @FindBy(id = "rememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(id = "forgot-password")
    private WebElement forgotPasswordButton;

    @FindBy(id = "response-status")
    private WebElement errorMessage;

    protected void login(String name, String password) {
        log.info(String.format("Login user name -%s , password -%s", name, password));
        inputLogin.sendKeys(name);
        inputPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sighInButton.click();
    }

     protected String getErrorMessageText() {
        return errorMessage.getText();
    }





}
