package helper;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TextMessage {

    private String textContentId = "com.grasshopper.dialer:id/tv_chat_text";

    private String mediaContentId = "com.grasshopper.dialer:id/image";

    // todo
    private String timestamp = "";

    // nullable
    private String message = "";

    // nullable
    public boolean isMMS = false;

    private MobileElement imageMobileElement;

    public MobileElement mobileElement;

    public TextMessage(MobileElement element){

        isMMS = false;

        message= "";

        this.mobileElement = element;

        try {
            imageMobileElement = mobileElement.findElement(By.id(mediaContentId));
            isMMS = true;
        }
        catch (Exception x)
        {
            // mms content is not present;
        }

        try{
            // trying to get text content.
            message = mobileElement.findElement(By.id(textContentId)).getText();
        }
        catch (Exception x){
            // text content is not present.
        }
    }

}
