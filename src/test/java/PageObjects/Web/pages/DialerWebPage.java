package PageObjects.Web.pages;

import PageObjects.base.BaseWebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DialerWebPage extends BaseWebPage {
    @FindBy(id="welcome-text")
    private WebElement userName;

    @FindBy(id="phone-page")
    private WebElement dialer;

    protected String getUserNameText(){
        return userName.getText();
    }

    protected Boolean isDialerDisplayed(){
        return dialer.isDisplayed();
    }
}
