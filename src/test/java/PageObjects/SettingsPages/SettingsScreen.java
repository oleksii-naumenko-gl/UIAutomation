package PageObjects.SettingsPages;

import PageObjects.base.BasePage;
import cucumber.api.java.en_scouse.An;
import helper.Extension;
import helper.SettingsItem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

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

    @AndroidFindBy(id = "com.grasshopper.dialer:id/rl_settings_incoming_title")
    private MobileElement incomingCallsSectionTitle;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/rl_settings_call_forwarding_id")
    private MobileElement callForwardingSettingsItem;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_call_forwarding_id")
    private MobileElement callForwardingSettingsItemTitle;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_call_forwarding_subtext")
    private MobileElement callForwardingSettingsItemSubtext;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/rl_my_extension_number")
    private MobileElement myExtensionSettingsItem;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/my_extension_number")
    private MobileElement myExtensionSettingsItemTitle;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/my_extension_subtext")
    private MobileElement myExtensionSettingsItemSubtext;

    @AndroidFindBy(xpath = "[//com.grasshopper.dialer:id/rl_settings_call_forwarding_id/com.grasshopper.dialer:id/arrow")
    private MobileElement callForwardingSettingsNavigationArrow;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/rl_settings_caller_info")
    private MobileElement callerInfoSettingsItemTitle;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_caller_info_subtext")
    private MobileElement callerInfoSettingsSubtext;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/iv_caller_info_switch")
    private MobileElement callerInfoSwitchButton;

    private MobileElement screenName = parentTopToolBar.findElementsByClassName("android.widget.TextView").get(0);

    public String getScreenNameFromTopBar() {
        return screenName.getText();
    }

    public String getIncomingCallsSectionTitle() {
        return incomingCallsSectionTitle.getText();
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public String getNumberLabel() {
        return numberLabel.getText();
    }

    public String getUserNumberText() {
        return userNumber.getText();
    }

    public String getSignOutButtonText() {
        return signOutButton.getText();
    }

    public String getCallForwardingSettingsItemTitle() {
        return callForwardingSettingsItemTitle.getText();
    }

    public String getCallForwardingSettingsItemSubtext() {
        return callForwardingSettingsItemSubtext.getText();
    }

    public String getCallerInfoSettingsItemTitle() {
        return callerInfoSettingsItemTitle.getText();
    }

    public String getCallerInfoSettingsDescriptionText() {
        return callerInfoSettingsSubtext.getText();
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
            logger.error("navigation arrow is not present in Call Forwarding settings section on Settings screen");
        }
        return isPresent;
    }

    public Boolean isCallerInfoTurnedOn() {
        Boolean state = false;
        if (callerInfoSwitchButton.getAttribute("text").equalsIgnoreCase("ON")) {
            state = true;
        }
        return state;
    }

    public void toggleCallerInfoSwitch() {
        logger.info("Switch Caller Info toggle");
        callerInfoSwitchButton.click();
    }

    public static SettingsItem[] settingsItems = SettingsItem.values();

    public void selectSettingsItem(String settingsItemName) {
        scrollUntilText(settingsItemName);
        String itemId = "";
        for (SettingsItem item : settingsItems) {
            if (item.getText().equalsIgnoreCase(settingsItemName)) {
                itemId = item.getId();
                break;
            }
        }
        driver.findElement(By.id(itemId)).click();
    }

    public String getMainExtensionDescription() {
        scrollUntilText(SettingsItem.MY_EXTENSION.getText());
        String text = myExtensionSettingsItemSubtext.getText();
        String desc = text.split("-")[0].trim();
        return desc;
    }
}
