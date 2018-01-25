package PageObjects.Web.helpers;

import PageObjects.base.BaseWebPage;
import helper.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonHelper extends BaseWebPage {

    public void signOut(){
        settingsDropdown.click();
        try {
            Thread.sleep(Constants.Timeouts.defaultActionTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signOutButton.click();
    }
}

