package driver;

import helper.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class DriverFactory {

     public static WebDriver getDriver() {
        WebDriver driver;
        String driverName = System.getProperty("browser");
        if ("firefox".equals(driverName)) {
            System.setProperty("webdriver.gecko.driver", "drivers/chromedriver.exe");
            driver = new FirefoxDriver();
        } else if ("chrome".equals(driverName)) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SharedData.BASE_URL);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}