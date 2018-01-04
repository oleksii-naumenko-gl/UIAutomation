package PageObjects.SettingsPages;

import PageObjects.base.BasePage;
import helper.Extension;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallForwardingSettingsPage extends BasePage {

    public CallForwardingSettingsPage(AppiumDriver driver) {
        super(driver);
    }

    public final String PAGE_TITLE = "Call Forwarding Settings";

    public  final  String PAGE_DESCRIPTION  = "Choose extension for which you want to update the call forwarding numbers";

    @AndroidFindBy(className = "android.widget.LinearLayout")
    private MobileElement pageContainer;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/status")
    private MobileElement forwardingNumberCounter;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/list")
    private MobileElement listOfExtensionsContainer;

   // private MobileElement pageTitle = parentTopToolBar.findElementByClassName("android.widget.TextView");

    private MobileElement pageDescription = pageContainer.findElementsByClassName("android.widget.TextView").get(0);

    private List<MobileElement> listOfExtension = listOfExtensionsContainer.findElements(By.className("android.widget.RelativeLayout"));

    public String getTextFromPageDescription() {
        return pageDescription.getText();
    }

    private MobileElement backButton = parentTopToolBar.findElementByClassName("android.widget.ImageButton");

    public void refreshAllAvailableExtensions() {
        SharedData.availableExtensionList.clear();

        for (MobileElement element : listOfExtension) {

            String extensionName="";
            String extensionDescription="";
            int forwardingNumberCounter;

            try {
                extensionDescription = element.findElement(By.id("com.grasshopper.dialer:id/description")).getText();
                extensionName = element.findElement(By.id("com.grasshopper.dialer:id/name")).getText();
            } catch (Exception x) {

            }

            String[] status = element.findElement(By.id("com.grasshopper.dialer:id/status")).getText().split(" ");
            String s = status[0];
            forwardingNumberCounter = Integer.parseInt(s);

            SharedData.availableExtensionList.add(new Extension(extensionName, extensionDescription, forwardingNumberCounter));
        }
    }

    private Map<String, MobileElement> setExtensionMap() {
        Map extensionHashMap = new HashMap<String, MobileElement>();
        MobileElement statusButton;
        String extensionDescription;


        for (MobileElement element : listOfExtension) {

            extensionDescription = element.findElement(By.id("com.grasshopper.dialer:id/description")).getText();
            statusButton = element.findElement(By.id("com.grasshopper.dialer:id/status"));
            extensionHashMap.put(extensionDescription, statusButton);
        }
        return extensionHashMap;
    }

    public void clickExtentionStatusButton(String extDescription) {
        setExtensionMap().get(extDescription).click();
    }

    public int getCounterOfForwardingNumbers(String extDescription) {
        List<Extension> extensionList = SharedData.availableExtensionList;
        int forwardingNumberCounter = 0;
        for (Extension ext : extensionList) {
            if (ext.getExtNumber().equalsIgnoreCase(extDescription)) {
                forwardingNumberCounter = ext.getForwardingNumberCounter();
            }
        }
        return forwardingNumberCounter;
    }

    public boolean isBackButtonDisplayed() {

        boolean isPresent = false;

        try {
            isPresent = backButton.isDisplayed();
        } catch (Exception x) {
            logger.error("Back button is not displayed on Call Forwarding Settings page");
        }
        return isPresent;
    }
    // public List<String> getNumbersForExtension

    // public void addNumberForExtension(Extension x, String name){

    // public void deleteNumberFromExtension(Extension x, StringNumber)

    //public void modifyNumberForExtension(Extension x, String numberBefore, String numberAfter)

}