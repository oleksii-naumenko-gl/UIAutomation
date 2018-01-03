package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SingleContactPage extends BasePage {
    public SingleContactPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/contact_number")
    private MobileElement contactNumber;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/text_back")
    private MobileElement textBackButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/call_back")
    private MobileElement callBackButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/add_to_favorites")
    private MobileElement addToFavoritesButton;


    public void clickContactsNumber(){
        contactNumber.click();
    }

    public void callContact(){
        clickContactsNumber();

        callBackButton.click();
    }

}
