package PageObjects;

import PageObjects.base.BasePage;
import helper.NavigationTab;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

/**
 * TODO: this class should be inherited by all classes that has such kind of menu (inbox, recent, call, etc)
 */
public class BottomNavigationBar extends BasePage{

    private final String iconId = "com.grasshopper.dialer:id/bottom_navigation_item_icon";

    public BottomNavigationBar(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/bottom_navigation")
    private MobileElement parentBar;


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
}
