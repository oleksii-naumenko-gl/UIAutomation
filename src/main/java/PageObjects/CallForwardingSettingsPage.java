package PageObjects;

import PageObjects.base.BasePage;
import helper.Extension;
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

    @AndroidFindBy(className = "android.widget.LinearLayout")
    private static MobileElement pageContainer;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/status")
    private MobileElement forwardingNumberCounter;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/list")
    private MobileElement listOfExtensionsContainer;



    private MobileElement pageTitle = parentTopToolBar.findElementByClassName("android.widget.TextView");

    private MobileElement pageDescription = pageContainer.findElementsByClassName("android.widget.TextView").get(0);

    private List<MobileElement> listOfExtension = listOfExtensionsContainer.findElements(By.className("android.widget.RelativeLayout"));

    public String getTextFromPageTitle() {
        return pageTitle.getText();
    }

    public String getTextFromPageDescription() {
        return pageDescription.getText();
    }

    protected MobileElement backButton = parentTopToolBar.findElementByClassName("android.widget.ImageButton");

    // public List<Extension> getAllAvailableExtensions without scrolling without actual numbers WITH counter

    public List<Extension> getAllAvailableExtensions() {
        List<Extension> extList = new ArrayList<>();

        for (MobileElement element : listOfExtension) {

            String extensionName;
            String extensionDescription;
            int forwardingNumberCounter;

            try {
                extensionDescription = element.findElement(By.id("com.grasshopper.dialer:id/description")).getText();
                extensionName = element.findElement(By.id("com.grasshopper.dialer:id/name")).getText();
            } catch (Exception x) {
                return extList;
            }

            String[] status = element.findElement(By.id("com.grasshopper.dialer:id/status")).getText().split(" ");
            String s = status[0];
            forwardingNumberCounter = Integer.parseInt(s);

            extList.add(new Extension(extensionName, extensionDescription, forwardingNumberCounter));

        }

        return extList;
    }


    public Map<String, MobileElement> setExtensionMap() {
        Map extensionHashMap = new HashMap<String, MobileElement>();
        MobileElement statusButton;
        String extensionDescription;

        for (MobileElement element : listOfExtension){

            extensionDescription= element.findElement(By.id("com.grasshopper.dialer:id/description")).getText();
            statusButton = element.findElement(By.id("com.grasshopper.dialer:id/status"));
            extensionHashMap.put(extensionDescription, statusButton);
        }
        return extensionHashMap;

    }

    public void clickOnExtentionStatusButton(String extDescription){
        setExtensionMap().get(extDescription).click();
    }

    public int getCounterOfForwardingNumbers(String extDescription) {
        List<Extension> extensionList= getAllAvailableExtensions();
        int forwardingStatus=0;
        for(Extension ext: extensionList){
            if(ext.description.equalsIgnoreCase(extDescription)){
               forwardingStatus = ext.forwardingNumberCounter;
            }
        }

       return forwardingStatus;
    }

//      todo
    public void scroll(){

    }
    public boolean isBackButtonDisplayed() {

        boolean isPresent = false;

        try {
            isPresent = backButton.isDisplayed();
        } catch (Exception x) {

        }

        return isPresent;
    }

            // public List<String> getNumbersForExtension

    // public void addNumberForExtension(Extension x, String name){




    // public void deleteNumberFromExtension(Extension x, StringNumber)

    //public void modifyNumberForExtension(Extension x, String numberBefore, String numberAfter)

    //

}
