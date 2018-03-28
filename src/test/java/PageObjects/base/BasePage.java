package PageObjects.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public abstract class BasePage {

    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger("PageLogger");

    protected final AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.grasshopper.dialer:id/toolbar")
    protected MobileElement parentTopToolBar;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@index='1']")
    protected MobileElement pageTitle;

    @AndroidFindBy(className = "android.widget.ImageButton")
    protected MobileElement backButton;


    public MobileElement findElementWithTimeout(By by, int timeOutInSeconds) {
        return (MobileElement) (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public String getTextFromPageTitle() {
        return pageTitle.getText();
    }

    public void tapInTheMiddleOfTheScreen() {
        try {
            WebElement x = driver.findElementById("com.grasshopper.dialer:id/toolbar");
            driver.tap(1, x.getLocation().getX() + Math.round((x.getSize().width) / 2), x.getLocation().getY() + Math.round((x.getSize().height) / 2), 1);
        } catch (Exception e) {
            throw e;
        }
    }

    public void swipeLeftfromObject(MobileElement element, Integer steps) {
        Dimension size = driver.manage().window().getSize();
        driver.swipe(element.getLocation().getX() + Math.round(((element.getSize().width) * 98) / 100), element.getLocation().getY() + Math.round((element.getSize().height) / 2), Math.round(size.getWidth() / 10), element.getLocation().getY() + Math.round((element.getSize().height) / 2), steps);
    }

    public void scrollUntilText(String textToFind) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + textToFind + "\"))"));
            WebElement x = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + textToFind + "\")"));
            //logger.info(" - Object found by Text: " + textToFind);
            assertTrue(textToFind, x.isDisplayed());
            //x.click();
        } catch (Exception e) {
            logger.error("***FAILED: Object not found due Invalid Text: " + textToFind);
            throw e;
        }
    }


}
