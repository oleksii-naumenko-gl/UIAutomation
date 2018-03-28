package PageObjects;

import PageObjects.base.BasePage;
import helper.Contact;
import helper.ForwardingNumber;
import helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.*;

public class ContactsPage extends BasePageWithBackButton {
    public ContactsPage(AppiumDriver driver) {
        super(driver);
    }

    private final String contactRowClassName = "android.widget.RelativeLayout";

    private final String contactNameId = "com.grasshopper.dialer:id/contact_name";

    private final String contactPhoneId = "com.grasshopper.dialer:id/contact_phone";

    @AndroidFindBy(id = "com.grasshopper.dialer:id/search_src_text")
    private MobileElement searchEditBox;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/search_close_btn")
    private MobileElement closeButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/contacts_list")
    private MobileElement contactList;

    private List<MobileElement> contactsOnTheScreen;

    public Map<Contact, MobileElement> contactsMap = new HashMap<>();

    public void initializeContacts() {

        contactsOnTheScreen = contactList.findElements(By.className(contactRowClassName));

        if (contactsOnTheScreen.size() != 0) {
            //doesn't include the last contact on screen because of element's partly displaying
            for (int index = 0; index <= contactsOnTheScreen.size() - 2; index++) {
                MobileElement element = contactsOnTheScreen.get(index);
                String contactName = element.findElement(By.id(contactNameId)).getText();
                String contactPhone = ForwardingNumber.modifyFormattedNumber(element.findElement(By.id(contactPhoneId)).getText());
                contactsMap.put(new Contact(contactName, contactPhone), element);
            }
        }
    }

    public void selectRandomContact() {

        if (contactsMap.size() == 0) {
            initializeContacts();
        }

        List<Contact> keysAsArray = new ArrayList<>(contactsMap.keySet());

        Random r = new Random();

        contactsMap.get(keysAsArray.get(r.nextInt(keysAsArray.size()))).click();
    }

    public void enterContactNumber(String number) {
        searchEditBox.sendKeys(Helper.modifyFormattedNumber(number));
    }
}
