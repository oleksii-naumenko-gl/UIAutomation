package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExtensionsLoginScreen extends BasePage {
    public ExtensionsLoginScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindAll({
            @FindBy(id = "com.grasshopper.dialer:id/sub_title"),
            @FindBy(xpath = ".//*[text()[contains(.,'Ext')]]")
    })

    private List<MobileElement> phoneInput;


    public void selectRandomExtension(){
        phoneInput.get(3).click();

    }

}
