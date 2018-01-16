package PageObjects.SettingsPages;

import PageObjects.base.BasePage;
import helper.Constants;
import helper.ForwardingNumber;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public class CallForwardingNumbersPage extends BasePage {

    public CallForwardingNumbersPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/list")
    private MobileElement parentListOfNumbersForExtension;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/empty_view")
    private MobileElement parentEmptyView;

    @AndroidFindBy(id="com.grasshopper.dialer:id/action_add")
    private MobileElement iconToAdd;


    public void clickIconToAdd() {
        logger.debug("Clicking on icon to add new forwarding number");
        iconToAdd.click();
    }

    public boolean isBackButtonDisplayed() {
        boolean isPresent = false;

        try {
            isPresent = backButton.isDisplayed();
        } catch (Exception x) {

            logger.error("Back button is not displayed on Call Forwarding Numbers page");
        }
        return isPresent;
    }

    public boolean isIconToAddDisplayed() {
        boolean isPresent = false;

        try {
            isPresent = iconToAdd.isDisplayed();
        } catch (Exception x) {
            logger.error("Icon to Add new forwarding numbers is not displayed on Call Forwarding Numbers page");
        }
        return isPresent;
    }

    public void clickBack() {
        backButton.click();
    }

    public void refreshForwardingNumbersPage() throws InterruptedException {
        SharedData.forwardingNumberList.clear();
        logger.info("Refresh forwarding number list");
        Thread.sleep(Constants.Timeouts.defaultActionTimeout);
        List<MobileElement> availableNumbersList = parentListOfNumbersForExtension.findElements(By.className("android.widget.RelativeLayout"));

        if (availableNumbersList.size() != 0) {
            for (MobileElement element : availableNumbersList) {
                ForwardingNumber number = new ForwardingNumber(element);
                SharedData.forwardingNumberList.add(number);
            }
        } else {
            logger.debug("No forwarding numbers present at the moment");
        }
    }

    public boolean isForwardingNumberChecked(String number) {
        boolean status = false;
        for (ForwardingNumber n : SharedData.forwardingNumberList) {
            if (n.getNumber().equalsIgnoreCase(number)) {
                status = n.getStatusOfCheckbox();
            }
        }
        return status;
    }

    public void clickForwardingNumberCheckbox(String number) {
        logger.info("Clicking on " + number+ " forwarding number checkbox");
        for (ForwardingNumber n : SharedData.forwardingNumberList) {
            if (n.getNumber().equalsIgnoreCase(number)) {
                n.getCheckboxMobileElement().click();
                break;
            }
        }
    }

    public void clickForwardingNumber(String numberToChange) {
        logger.info("Clicking on " + numberToChange+ " forwarding number");

        for (ForwardingNumber n : SharedData.forwardingNumberList) {
            if (n.getNumber().equalsIgnoreCase(numberToChange)) {
                n.getNumberMobileElement().click();
                break;
            }
        }

    }
}
