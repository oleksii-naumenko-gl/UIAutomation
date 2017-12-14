package PageObjects;

import helper.Constants;
import helper.SharedData;
import helper.TextMessage;
import helper.TextsEntry;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.List;

public class NewConversationScreen extends ContactsPage {
    public NewConversationScreen(AppiumDriver driver) {
        super(driver);
    }

    private String textElementParentClassName = "android.widget.FrameLayout";

    @AndroidFindBy(id = "com.grasshopper.dialer:id/et_text_entry")
    private MobileElement textInputTextbox;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/tv_send")
    private MobileElement sendButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/attachment_button")
    private MobileElement attachmentButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/take_photo")
    private MobileElement takeNewPhoto;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/attach_photo")
    private MobileElement attachExistingPhoto;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/attach_video")
    private MobileElement attachVideo;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/chat_list")
    private MobileElement chatListParent;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/delete")
    private MobileElement deleteTapMenuButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/copy")
    private MobileElement copyTapMenuButton;

    @AndroidFindBy(id = "com.android.documentsui:id/dir_list")
    private MobileElement savedImagesParent;

    @AndroidFindBy(id = "com.android.documentsui:id/icon_thumb")
    public List<MobileElement> savedImagesList;

    @AndroidFindBy(id = "com.android.documentsui:id/toolbar")
    public MobileElement openImageTopMenuParent;

    public void startConversation(){
        if (textInputTextbox.getText().equalsIgnoreCase("Click here to start conversation")){
            textInputTextbox.click();

            // tapping in order to remove informational message about mms possibilities that will probably appear here.
            // todo only needed after clean installation
//            super.tapInTheMiddleOfTheScreen();
        }
    }

    public void enterMessage(String message){
        textInputTextbox.sendKeys(message);
    }

    public void pressSendButton(){
        sendButton.click();
    }

    public void sendNewMessage(String message){
        enterMessage(message);
        pressSendButton();
    }

    public void sendNewRandomMessageWithTimestamp(){
        String timeStamp = new SimpleDateFormat("MM.dd.HH.mm.ss").format(new java.util.Date());
        timeStamp = "TestMessage " + timeStamp;
        sendNewMessage(timeStamp);
    }

    public void sendNewImage() throws InterruptedException {
        pressAttacmentButton();
        takeNewPhoto.click();
        takeNewPhoto();
        pressSendButton();
    }

    public void sendRandomExistingImage() throws InterruptedException {
        pressAttacmentButton();
        attachExistingPhoto.click();
        selectRandomExistingImage();
        pressSendButton();
    }

    public void sendRandomExistingVideo(){
        pressAttacmentButton();
        attachVideo.click();



    }

    public void pressAttacmentButton(){
        attachmentButton.click();
    }

    private void takeNewPhoto() throws InterruptedException {
        Thread.sleep(Constants.Timeouts.defaultActionTimeout);

        // taking photo
        driver.tap(1, 535, 1653, 100);
        Thread.sleep(Constants.Timeouts.longActionTimeout);
        // clicking Yes button
        driver.tap(1, 655, 1560, 100);

        Thread.sleep(Constants.Timeouts.longActionTimeout);
    }

    private void selectRandomExistingImage() throws InterruptedException {
        // holding for menu to appear
        driver.tap(1, savedImagesList.get(0).getLocation().getX() + Math.round((savedImagesList.get(0).getSize().width)/2),
                savedImagesList.get(0).getLocation().getY()+Math.round((savedImagesList.get(0).getSize().height)/2), 1000);

        clickOpenButton();

        Thread.sleep(Constants.Timeouts.defaultActionTimeout);
    }

    public void getAllMessages(){
        SharedData.messagesList.clear();

        // hide keyboard to see all the last messages
        driver.hideKeyboard();

        List<MobileElement> messages = chatListParent.findElements(By.className(textElementParentClassName));

        for (MobileElement element : messages){
                   if (element.findElements(By.xpath("//*")).size() > 1){
                       SharedData.messagesList.add(new TextMessage(element));
                   }
        }
    }

    public void deleteMessage(TextMessage message){

        driver.tap(1, message.mobileElement.getLocation().getX() + Math.round((message.mobileElement.getSize().width)/2),
                message.mobileElement.getLocation().getY()+Math.round((message.mobileElement.getSize().height)/2),1000);

        deleteTapMenuButton.click();
    }

    private void clickOpenButton(){

        List<MobileElement> mobileElements = openImageTopMenuParent.findElements(By.className("android.widget.ImageButton"));

        mobileElements.get(1).click();
    }

}
