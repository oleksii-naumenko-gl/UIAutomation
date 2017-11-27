package PageObjects;

import PageObjects.base.BasePage;
import cucumber.api.java.cs.A;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsScreen extends BasePage {

    public SettingsScreen(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "com.grasshopper.dialer:id/logout")
    private MobileElement signOutButton;


    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_name")
    private MobileElement userName;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_number_label")
    private MobileElement numberLabel;

    @AndroidFindBy(id = " com.grasshopper.dialer:id/tv_number")
    private MobileElement userNumber;

    @AndroidFindBy(id="com.grasshopper.dialer:id/rl_settings_incoming_title")
    private MobileElement incomingCallsSectionTitle;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/rl_settings_call_forwarding_id")
    private MobileElement callForwardingSettingsItem;

    @AndroidFindBy(id="com.grasshopper.dialer:id/tv_call_forwarding_id")
    private MobileElement callForwardingSettingsItemTitle;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_call_forwarding_subtext")
    private MobileElement callForwardingSettingsItemSubtext;



    private MobileElement callForwardingSettingsNavigationArrow = callForwardingSettingsItem.findElementById("com.grasshopper.dialer:id/arrow");

    private MobileElement screenName = parentTopToolBar.findElementsByClassName("android.widget.TextView").get(0);

    public String getScreenNameFromTopBar() {

        return screenName.getText();
    }

    public boolean isSignOutButtonPresent() {

        boolean isPresent = false;

        try {
            isPresent = signOutButton.isDisplayed();
        } catch (Exception x) {

        }

        return isPresent;
    }

    public boolean isCallForwardingSettingsNavigationArrowPresent() {

        boolean isPresent = false;

        try {
            isPresent = callForwardingSettingsNavigationArrow.isDisplayed();
        } catch (Exception x) {

        }

        return isPresent;
    }

    public String getTextFromIncomingCallsSectionTitle(){
        return incomingCallsSectionTitle.getText();
    }

    public String getTextFromUserName() {
        return userName.getText();
    }

    public String getTextFromNumberLabel() {
        return numberLabel.getText();
    }

    public String getTextFromUserNumber() {
        return userNumber.getText();
    }


    public String getTextFromSignOutButton() {
        return signOutButton.getText();
    }

    public String getTextFromCallForwardingSettingsItemTitle(){
        return callForwardingSettingsItemTitle.getText();
    }
    public String getTextFromCallForwardingSettingsItemSubtext(){
        return callForwardingSettingsItemSubtext.getText();
    }
    public void clickOnCallForwardingSettingsNavigationArrow(){
        callForwardingSettingsNavigationArrow.click();
    }




}
