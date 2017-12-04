package PageObjects;

import PageObjects.base.BasePage;
import helper.Contact;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.*;

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

    private List<MobileElement> favoritesOnTheScreen;

    public Map<Contact, MobileElement> getFavoritesMap(){

        return SharedData.favoritesMap;
    }

    public void pressEdit(){
        try{
            logger.debug("Clicking Edit button on Favorites screen");
            editButton.click();
        }
        catch (Exception x){
            logger.error("Edit button was not found");
        }
    }

    public void addNewFavorite(){
        pressEdit();

        addButton.click();
    }

    public void callFavoite(Contact contact){

        try{
            getFavoritesMap().get(contact).click();
        }
        catch (Exception x)
        {
            logger.error("Contact is not present");
        }
    }

    public Contact getRandomFavoite(){
        getFavoritesMap();

        List<Contact> keysAsArray = new ArrayList<>(getFavoritesMap().keySet());

        Random r = new Random();

        return keysAsArray.get(r.nextInt(keysAsArray.size()));
    }

    public void initializeFavorites(){
        favoritesOnTheScreen = favoritesParent.findElements(By.id(favoriteLineId));

        if (favoritesOnTheScreen.isEmpty()){
            return;
        }

        else{
            for (MobileElement element : favoritesOnTheScreen){
                String name = element.findElement(By.id(contactNameId)).getText();
                String number = element.findElement(By.id(contactNumberId)).getText();

                SharedData.favoritesMap.put(new Contact(name, number), element);
            }
        }
    }



}
