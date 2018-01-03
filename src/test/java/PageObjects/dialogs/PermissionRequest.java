package PageObjects.dialogs;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PermissionRequest extends BasePage{
    public PermissionRequest(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement allowButton;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private MobileElement denyButton;

    @AndroidFindBy(id = "com.android.packageinstaller:id/dialog_container")
    private MobileElement permissionMessage;

    public void allowAccess(){
        allowButton.click();
    }

    public boolean isPermissionMessagePresent(){
        boolean isPresent = false;

        try {
            isPresent = permissionMessage.isDisplayed();
        }
        catch (Exception x){
        }

        return isPresent;
    }
}
