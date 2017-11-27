package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CallPage extends BaseActionPage {
    public CallPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/et_number_entry")
    private MobileElement numberInput;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/call_row")
    private MobileElement callButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/contacts")
    private MobileElement contactsButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/favorites")
    private MobileElement favoritesButton;


}
