package helper;

import PageObjects.CallForwardingSettingsPage;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ExtensionOnCallForwardingPage {
    String description;
    MobileElement extensionNumber;
    MobileElement forwardingStatus;


    public ExtensionOnCallForwardingPage( MobileElement extensionName, MobileElement extensionNumber, MobileElement forwardingStatus) {

        this.description = String.valueOf(extensionName);
        this.extensionNumber = extensionNumber;
        this.forwardingStatus = forwardingStatus;

    }


    @Test
    public List<ExtensionOnCallForwardingPage> getAllAvailableExtensions(){
        List<ExtensionOnCallForwardingPage> allAvailableExtensions= new ArrayList<>();

        List<MobileElement> description= CallForwardingSettingsPage.pageContainer.findElements(By.id("com.grasshopper.dialer:id/name"));
        List<MobileElement> extensionNumber=CallForwardingSettingsPage.pageContainer.findElements(By.id("com.grasshopper.dialer:id/description"));
        List<MobileElement> forwardingStatus=CallForwardingSettingsPage.pageContainer.findElements(By.id("com.grasshopper.dialer:id/status"));
        int numberOfExtension = description.size();
        int index = 0;
        while (index < numberOfExtension) {
            allAvailableExtensions.add(new ExtensionOnCallForwardingPage(description.get(index), extensionNumber.get(index), forwardingStatus.get(index)));
            index++;
        }
        return allAvailableExtensions;
    }


}
