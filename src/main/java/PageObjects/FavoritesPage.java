package PageObjects;

import PageObjects.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FavoritesPage extends BasePage{
    public FavoritesPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tabs")
    private MobileElement tabsParent;
    // class android.support.v7.app.ActionBar$Tab, index 0 and 1

    @AndroidFindBy(id = "com.grasshopper.dialer:id/container")
    private MobileElement favoritesParent;

    // TODO: move to parent after V's tests are done

    @AndroidFindBy(id = "com.grasshopper.dialer:id/edit")
    private MobileElement editButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/search_button")
    private MobileElement searchButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/toolbar")
    private MobileElement parentTopBar;

    private MobileElement screenName = parentTopBar.findElementByXPath("//[@resource-id='com.grasshopper.dialer:id/toolbar'/*[1]");




}
