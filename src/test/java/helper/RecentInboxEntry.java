package helper;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Recent or Inbox entry that contains date, contact name/phone number and extension.
 */
public class RecentInboxEntry {

    public String contact;

    public String timestamp;

    public String extension;

    public boolean isUnread;

    public MobileElement mobileElement;

    private String recentMapContact = "com.grasshopper.dialer:id/from";

    private String recentMapTimestamp = "com.grasshopper.dialer:id/received_time";

    private String recentMapExtension = "com.grasshopper.dialer:id/extension_name";

    private String inboxMapExtension = "com.grasshopper.dialer:id/extension_info";

    private String unreadCounterIconId = "com.grasshopper.dialer:id/dot_icon";

    private String detailsIconId = "com.grasshopper.dialer:id/info";

    public RecentInboxEntry(MobileElement element, boolean isRecent) {

        this.mobileElement = element;

        this.isUnread = false;

        try{
            element.findElement(By.id(unreadCounterIconId));
            isUnread = true;
        }
        catch (Exception x){
            // that means that unread icon is not present.
        }

        this.contact = element.findElement(By.id(recentMapContact)).getText();
        this.timestamp = element.findElement(By.id(recentMapTimestamp)).getText();

        if (isRecent) {
            this.extension = element.findElement(By.id(recentMapExtension)).getText();
        }
        else {
            this.extension = element.findElement(By.id(inboxMapExtension)).getText();

        }
    }

    public void openDetails() {
         mobileElement.findElement(By.id(detailsIconId)).click();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!RecentInboxEntry.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final RecentInboxEntry other = (RecentInboxEntry) obj;

        if (!this.contact.equals(other.contact) || !this.timestamp.equals(other.timestamp))
        {
            return false;
        }

        return true;
    }

}
