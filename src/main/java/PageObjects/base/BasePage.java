package PageObjects.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public abstract class BasePage {

    protected final AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement findElementWithTimeout(By by, int timeOutInSeconds) {
        return (MobileElement)(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void takeScreenShot(){
        driver.getScreenshotAs(OutputType.BASE64);
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    private void PressHome(){
    }

    // todo method from generic steps here

    public void tapInTheMiddle(){
        try {
            WebElement x = driver.findElementById("com.grasshopper.dialer:id/toolbar");
            driver.tap(1,x.getLocation().getX()+Math.round((x.getSize().width)/2),x.getLocation().getY()+Math.round((x.getSize().height)/2),1);
        }
        catch (Exception e){
            throw e;
        }
    }
}
