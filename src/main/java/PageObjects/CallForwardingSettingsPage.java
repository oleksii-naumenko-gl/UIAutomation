package PageObjects;

import PageObjects.base.BasePage;
import helper.Extension;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class CallForwardingSettingsPage extends BasePage {


    public CallForwardingSettingsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.LinearLayout")
    public static MobileElement pageContainer;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/status")
    private MobileElement forwardingNumberCounter;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/list")
    private MobileElement listOfExtensionsContainer;


    // public List<Extension> getAllAvailableExtensions without scrolling without actual numbers WITH counter


    private MobileElement pageTitle = parentTopToolBar.findElementByClassName("android.widget.TextView");

    private MobileElement backButton = parentTopToolBar.findElementByClassName("android.widget.ImageButton");

    private MobileElement pageDescription = pageContainer.findElementsByClassName("android.widget.TextView").get(0);

    public String getTextFromPageTitle() {
        return pageTitle.getText();
    }

    public String getTextFromPageDescription() {
        return pageDescription.getText();
    }

    public boolean isBackButtonDisplayed() {

        boolean isPresent = false;

        try {
            isPresent = backButton.isDisplayed();
        } catch (Exception x) {

        }

        return isPresent;
    }


    // public List<Extension> getAllAvailableExtensions without scrolling without actual numbers WITH counter

    public List<Extension> getAllAvailableExtensions() {
        List<MobileElement> list = listOfExtensionsContainer.findElements(By.className("android.widget.RelativeLayout"));
        List<Extension> extList = new ArrayList<>();


        for (MobileElement element : list) {
            String extensionName = element.findElement(By.id("com.grasshopper.dialer:id/name")).getText();
            String extensionDescription = element.findElement(By.id("com.grasshopper.dialer:id/description")).getText();

            String[] status = element.findElement(By.id("com.grasshopper.dialer:id/status")).getText().split(" ");
            String s = status[0];
            int forwardingNumberCounter = Integer.parseInt(s);



                extList.add(new Extension(extensionName, extensionDescription, forwardingNumberCounter));

                //element.click();

                // достаем номер дескрипшн и кол-во экстешнов

//            element.findElement(......)



        }


        return extList;
    }
    public void printList(){
        getAllAvailableExtensions().forEach(System.out::println);

    }

    // public List<String> getNumbersForExtension

    // public void addNumberForExtension(Extension x, String number)

    // public void deleteNumberFromExtension(Extension x, StringNumber)

    //public void modifyNumberForExtension(Extension x, String numberBefore, String numberAfter)

    //

}
