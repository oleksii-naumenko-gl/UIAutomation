package PageObjects;

import PageObjects.base.BasePage;
import helper.Contact;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class FavoritesPage extends BasePage{
    public FavoritesPage(AppiumDriver driver) {
        super(driver);
    }

    private String favoriteLineId = "com.grasshopper.dialer:id/swipe";

    private String contactNameId = "com.grasshopper.dialer:id/contact_name";

    private String contactNumberId = "com.grasshopper.dialer:id/contact_phone";

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tabs")
    private MobileElement tabsParent;
    // class android.support.v7.app.ActionBar$Tab, index 0 and 1

    @AndroidFindBy(id = "com.grasshopper.dialer:id/list")
    private MobileElement favoritesParent;

    // TODO: move to parent after V's tests are done
    @AndroidFindBy(id = "com.grasshopper.dialer:id/edit")
    private MobileElement editButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/search_button")
    private MobileElement searchButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/add")
    private MobileElement addButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/toolbar")
    private MobileElement parentTopBar;

    // com.grasshopper.dialer:id/add

    // com.grasshopper.dialer:id/cancel done


    // todo
//    private MobileElement screenName = parentTopBar.findElementByXPath("//[@resource-id='com.grasshopper.dialer:id/toolbar'/*[1]");

    public void pressEdit(){
        try{
            logger.debug("Clicking Edit button on Favorites screen");
            editButton.click();
        }
        catch (Exception x){
            logger.error("Edit button was not found");
        }
    }

    public List<Contact> getFavoriteContacts(){

        List<MobileElement> favorites = favoritesParent.findElements(By.id(favoriteLineId));

        List<Contact> contacts = new ArrayList<>();

        if (favorites.isEmpty()){
            return null;
        }
        else{
            for (MobileElement element : favorites){
                String name = element.findElement(By.id(contactNameId)).getText();
                String number = element.findElement(By.id(contactNumberId)).getText();
                contacts.add(new Contact(name, number));
            }
        }

        return contacts;
    }

    public void addNewFavorite(String contactName){
        pressEdit();

        addButton.click();
    }


}
