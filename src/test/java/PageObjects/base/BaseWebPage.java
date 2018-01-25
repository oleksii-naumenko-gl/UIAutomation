package PageObjects.base;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseWebPage {

    protected WebDriver driver = MyDriver.getMyDriver();
    protected Logger log = LogManager.getLogger(this.getClass());

    @FindBy(className = "icon-settings-pad")
    protected WebElement settingsDropdown;

    @FindBy(id = "signout")
    protected WebElement signOutButton;
    public void appOut() {
        driver.quit();
    }


    public BaseWebPage() {
        PageFactory.initElements(driver, this);
    }





}
