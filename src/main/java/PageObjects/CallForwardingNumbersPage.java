package PageObjects;

import PageObjects.base.BasePage;
import helper.Extension;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CallForwardingNumbersPage extends BasePage {

    public CallForwardingNumbersPage(AppiumDriver driver) {
        super(driver);
    }

    private MobileElement pageTitle = parentTopToolBar.findElementByClassName("android.widget.TextView");

    private MobileElement iconToAdd = parentTopToolBar.findElementById("com.grasshopper.dialer:id/action_add");

    private MobileElement backButton = parentTopToolBar.findElementByClassName("android.widget.ImageButton");

    @AndroidFindBy(id="com.grasshopper.dialer:id/list")
    private MobileElement listOfNumbersForExtension;

    private List<MobileElement> availableForwardingNumbers = listOfNumbersForExtension.findElements(By.className("android.widget.RelativeLayout"));

    @AndroidFindBy(id="com.grasshopper.dialer:id/empty_view")
    private MobileElement parentEmptyView;


    public String getTextFromPageTitle() {
        return pageTitle.getText();
    }


    public void clickOnIconToAdd() throws IOException {

        iconToAdd.click();
    }

    public boolean isBackButtonDisplayed() {

        boolean isPresent = false;

        try {
            isPresent = backButton.isDisplayed();
        } catch (Exception x) {

        }

        return isPresent;
    }

    public boolean isIconToAddDisplayed() {

        boolean isPresent = false;

        try {
            isPresent = iconToAdd.isDisplayed();
        } catch (Exception x) {

        }

        return isPresent;
    }

    public void clickOnBackButton(){
        backButton.click();
    }



}
