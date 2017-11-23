package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsScreen extends BasePage {

    @AndroidFindBy(id = "com.grasshopper.dialer:id/toolbar")
    private MobileElement toolbar;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/logout")
    private MobileElement signOutButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/toolbar")
    private MobileElement parentTopBar;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_name")
    private MobileElement userName;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_number_label")
    private MobileElement numberLabel;

    @AndroidFindBy(id = " com.grasshopper.dialer:id/tv_number")
    private MobileElement userNumber;

    public SettingsScreen(AppiumDriver driver) {
        super(driver);
    }

    private MobileElement screenName = parentTopBar.findElementByXPath("//[@resource-id='com.grasshopper.dialer:id/toolbar'/*[1]");

    public String getTextFromTopBar(){

        return screenName.getText();
    }
    public String getTextFromUserName(){
        return userName.getText();
    }
    public  String getTextFromNumberLabel(){
        return numberLabel.getText();
    }
    public String getTextFromUserNumber(){
        return userNumber.getText();
    }

}
