package helper;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TextsEntry {

    private String unreadCounterIconId = "com.grasshopper.dialer:id/is_read_indicator";

    private String textFromId = "com.grasshopper.dialer:id/from";

    private String textMessageId = "com.grasshopper.dialer:id/message";

    private String textTimestampId = "com.grasshopper.dialer:id/received_time";

    public String contact;

    public String timestamp;

    public String messagePreview;

    public boolean isUnread;

    public MobileElement mobileElement;

    public TextsEntry(MobileElement element) {

        this.isUnread = false;

        try{
            element.findElement(By.id(unreadCounterIconId));
            isUnread = true;
        }
        catch (Exception x){
            // that means that unread icon is not present.
        }

        this.contact = element.findElement(By.xpath("//*[contains(@resource-id,'id/from')]")).getText();


        if (this.contact.substring(this.contact.length() - 1).equals(" ")){
            this.contact = this.contact.substring(0, this.contact.length() - 1);
        }

        this.timestamp = element.findElement(By.id(textTimestampId)).getText();
        try{
            this.messagePreview = element.findElement(By.id(textMessageId)).getText();
        }catch(Exception e){
            // that means that conversation doesn't messages.

        }
        this.mobileElement = element;
    }

    public void openDialog() throws InterruptedException {
        mobileElement.click();

        Thread.sleep(Constants.Timeouts.longActionTimeout);
        // add waiting for dialog opening
    }
}
