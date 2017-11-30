package PageObjects.dialogs;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseDialog extends BasePage {

    public BaseDialog(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/circle_progress")
    private MobileElement progressBar;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private MobileElement denyButton;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement allowButton;

    @AndroidFindBy(id = "com.android.packageinstaller:id/dialog_container")
    private MobileElement dialog;

    public boolean isDialogPresent(){

        boolean isPresent = false;

        try {
            isPresent = dialog.isDisplayed();
        }
        catch (Exception x){

        }

        return isPresent;
    }

    public void denyDialog(){
        denyButton.click();
    }

    public void acceptDialog(){
        allowButton.click();
    }

    public void waitUntilProgressDisappears() throws InterruptedException {
        try {
            (new WebDriverWait(driver, 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.grasshopper.dialer:id/circle_progress")));
        } catch (TimeoutException e) {
        }

    }
}
