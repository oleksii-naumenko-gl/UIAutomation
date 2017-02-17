package PageObjects;

import Features.LoginFeature;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class GrasshopperApp {

    private GrasshopperApp() { }

    private AndroidDriver driver;

    private static GrasshopperApp instance;

//    public final LoginFeature login = new LoginFeature();

    /**
     * Application instance initialization
     * @return single application instance
     */
    public static GrasshopperApp getInstance() {
        if (instance == null) {
            instance = new GrasshopperApp();
        }

        return instance;
    }

    public AppiumDriver getAndroidWebDriver() {
        File appDir = new File("/Users/admin/IdeaProjects/GrasshopperAutomation/AT");
        File app = new File(appDir, "Grasshopper.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        capabilities.setCapability("platformVersion","6.0.1");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return  driver;
    }

    public void getIOSWebDriver(){};


}
