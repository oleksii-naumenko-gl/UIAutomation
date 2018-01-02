package PageObjects.SettingsPages;

import PageObjects.base.BasePage;
import helper.Extension;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class MyExtensionPage extends BasePage {
    public MyExtensionPage(AppiumDriver driver) {
        super(driver);
    }

    public final String PAGE_TITLE_TEXT = "My Extension";

    public final String PAGE_DESCRIPTION_TEXT = "What extension should we log the calls to (for reporting purposes)";

    @AndroidFindBy(id = "com.grasshopper.dialer:id/title")
    private MobileElement pageDescription;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.RelativeLayout")
    private List<MobileElement> myExtensionList;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/title")
    private MobileElement extNameMobileElement;

    public void refreshMyExtensionsSettingsList() {
        SharedData.myExtensionSettingsList.clear();
        String extNameId = "com.grasshopper.dialer:id/title";
        String extDescriptionId = "com.grasshopper.dialer:id/sub_title";
        String checkboxId = "com.grasshopper.dialer:id/checkbox";
        for (MobileElement ext : myExtensionList) {

            String extDescription = ext.findElementById(extNameId).getText();

            String extNumber = ext.findElementById(extDescriptionId).getText();
            Boolean isCheckboxExisted;
            try {

                isCheckboxExisted = ext.findElementById(checkboxId).isDisplayed();
            } catch (Exception e) {
                isCheckboxExisted = false;
            }

            SharedData.myExtensionSettingsList.add(new Extension(extDescription, extNumber, isCheckboxExisted, ext));
        }
    }

    public Extension selectExtension(String extensionNumber) {
        Extension selectedExtension = null;
        for (Extension ext : SharedData.myExtensionSettingsList) {
            if (ext.getExtNumber().equalsIgnoreCase(extensionNumber)) {
                selectedExtension = ext;
                break;
            }
        }
        if (selectedExtension == null) {
            logger.error(String.format("\"-%s\" Extension doesn't exist", extensionNumber));
            throw new NoSuchElementException("Extension  doesn't exist");
        }
        return selectedExtension;
    }

    public void clickExtension(String extensionNumber) {
        logger.info(String.format("Click \"-%s\" Extension ", extensionNumber));
        selectExtension(extensionNumber).getExtMobileElement().click();
    }
}
