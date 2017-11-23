package PageObjects;

import PageObjects.base.BasePage;
import helper.NavigationTab;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Base class for Inbox, Recent, Dialer and Texts
 */
public class BaseActionPage extends BasePage{

    private final String iconId = "com.grasshopper.dialer:id/bottom_navigation_item_icon";

    public BaseActionPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/bottom_navigation")
    private MobileElement parentBar;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/toolbar")
    private MobileElement topToolbar;

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement dropboxValue;

    @AndroidFindBy(className = "android.widget.Spinner")
    private MobileElement dropbox;

    private List<MobileElement> getNavigationTabs(){
        return parentBar.findElements(By.id("com.grasshopper.dialer:id/bottom_navigation_container"));
    }

    public void selectTab(NavigationTab tab)
    {
        getNavigationTabs().get(tab.getValue()).click();
    }

    public boolean isTabSelected(NavigationTab tab){
        MobileElement neededTab = getNavigationTabs().get(tab.getValue());
        MobileElement neededTabIcon = neededTab.findElement(By.id(iconId));
        neededTabIcon.isSelected();

        return neededTabIcon.isSelected();
    }

    public String getSelectedDropdownValue(){
        return dropboxValue.getText();
    }

    public void setDropdownValue(String value) throws InterruptedException {

        dropbox.click();

        // getting all elements
        List<MobileElement> listOfValues = driver.findElements(By.id("android:id/text1"));

        for (MobileElement entry : listOfValues){
            if (entry.getText().equalsIgnoreCase(value)){
                entry.click();
                return;
            }
        }

        throw (new NoSuchElementException());
    }

}
