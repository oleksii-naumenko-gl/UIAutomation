package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class ExtensionSelectionScreen extends BasePage{
    public ExtensionSelectionScreen(AppiumDriver driver) {
        super(driver);
    }
    // select extension method

    @AndroidFindBy(id = "com.grasshopper.dialer:id/listView")
    private MobileElement parentExtensionList;

    public void selectFirstExtension(){
        // todo: add scrolling as the method will return only all visible extension numbers
        List<MobileElement> list = parentExtensionList.findElements(By.className("android.widget.RelativeLayout"));

        // selecting first extension
        list.get(0).click();
    }
}
