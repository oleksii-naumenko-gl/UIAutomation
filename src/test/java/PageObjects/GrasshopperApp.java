package PageObjects;

import PageObjects.SettingsPages.*;
import PageObjects.dialogs.BaseAlert;
import PageObjects.dialogs.BaseDialog;
import PageObjects.dialogs.DeleteDestinationDialog;
import PageObjects.dialogs.PermissionRequest;
import cucumber.api.Scenario;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class GrasshopperApp {

    private GrasshopperApp() {
    }

    private static AndroidDriver driver;

    // test
    private static AppiumDriver iosDriver;

    private static GrasshopperApp instance;

    public static GrasshopperApp getInstance() {
        if (instance == null) {
            getProperties();

            // todo: move from here to new driver class
            driver = setup();
            instance = new GrasshopperApp();
        }

        return instance;
    }

    public static GrasshopperApp getIosInstance() throws MalformedURLException {
        if (instance == null) {
            getProperties();

            iosDriver = setupIOSCapabilities();
            instance = new GrasshopperApp();
        }

        return instance;
    }


    public void endSession() {
        driver.quit();
        instance = null;
    }

    // Pages initialization
    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public GetStartedPage getStartedPage() {
        return new GetStartedPage(driver);
    }

    public ExtensionSelectionScreen extensionSelectionScreen() {
        return new ExtensionSelectionScreen(driver);
    }

    public BaseActionPage bottomNavigationBar() {
        return new BaseActionPage(driver);
    }

    public VOIPLoginPage voipLoginPage() {
        return new VOIPLoginPage(driver);
    }

    public InboxPage inboxPage() {
        return new InboxPage(driver);
    }

    public RecentPage recentPage() {
        return new RecentPage(driver);
    }

    public CallPage callPage() {
        return new CallPage(driver);
    }

    public TextsPage textsPage() {
        return new TextsPage(driver);
    }

    public WifiCallPage wifiCallPage() {
        return new WifiCallPage(driver);
    }

    public FavoritesPage favoritesPage() {
        return new FavoritesPage(driver);
    }

    public SettingsScreen settingsScreen() {
        return new SettingsScreen(driver);
    }

    public CallForwardingSettingsPage callForwardingSettingsPage() {
        return new CallForwardingSettingsPage(driver);
    }

    public ContactsPage contactsPage() {
        return new ContactsPage(driver);
    }

    public CallForwardingNumbersPage callForwardingNumbersPage() {
        return new CallForwardingNumbersPage(driver);
    }

    public NewDestinationPage newDestinationPage() {
        return new NewDestinationPage(driver);
    }

    public EditDestinationPage editDestinationPage() {
        return new EditDestinationPage(driver);
    }

    public DeleteDestinationDialog deleteDestinationDialog() {
        return new DeleteDestinationDialog(driver);
    }

    public AccessNumberPage accessNumberPage() {
        return new AccessNumberPage(driver);
    }

    public MakingCallsPage makingCallsPage() {
        return new MakingCallsPage(driver);
    }

    public MyExtensionPage myExtensionPage() {
        return new MyExtensionPage(driver);
    }

    public VoicemailDetails voicemailDetails() {
        return new VoicemailDetails(driver);
    }

    public SingleContactPage singleContactPage() {
        return new SingleContactPage(driver);
    }

    public BaseDialog baseDialog() {
        return new BaseDialog(driver);
    }

    public NewConversationScreen newConversationScreen() {
        return new NewConversationScreen(driver);
    }

    public BaseAlert baseAlert() {
        return new BaseAlert(driver);
    }

    public PermissionRequest permissionRequest() {
        return new PermissionRequest(driver);
    }

    public AddNewContactMoto addNewContactMoto() {
        return new AddNewContactMoto(driver);
    }

    public LegalDisclaimerDialog legalDisclaimerDialog() {
        return new LegalDisclaimerDialog(driver);
    }

    public static void getProperties() {
        if (System.getProperties() != null) {
            SharedData.appPath = System.getProperty("grasshopper_apk_path");
            SharedData.phoneAndroidVersion = System.getProperty("test_android_version");
            SharedData.appiumServer = System.getProperty("appium_server_url");
            SharedData.grasshopperVersion = System.getProperty("grasshopper_build_version");
        } else {
            try {
                File file = new File("config.properties");
                FileInputStream fileInput = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInput);
                fileInput.close();

                SharedData.appPath = properties.getProperty("grasshopper_apk_path");
                SharedData.phoneAndroidVersion = properties.getProperty("test_android_version");
                SharedData.appiumServer = properties.getProperty("appium_server_url");
                SharedData.grasshopperVersion = properties.getProperty("grasshopper_build_version");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static AndroidDriver setup(String emulatorName, String androidVersion) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupBasicCapabilities(capabilities);
        setupEmulatorCapabilities(capabilities, emulatorName, androidVersion);

        return setupDriver(capabilities);
    }

    public static AndroidDriver setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupBasicCapabilities(capabilities);

        return setupDriver(capabilities);
    }

    /**
     * Setting up new instance of Appium Driver using
     *
     * @param capabilities the capabilities to be used
     * @return new instance of Driver
     */
    private static AndroidDriver setupDriver(DesiredCapabilities capabilities) {
        AndroidDriver driver = null;

        try {
            driver = new AndroidDriver(new URL(SharedData.appiumServer), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    /**
     * Setups all basic cababilites for Appium driver excluding emulator specific ones or needed for restarting the script
     * with the same app installed
     *
     * @param capabilities
     */
    private static void setupBasicCapabilities(DesiredCapabilities capabilities) {
        File appDir = new File(SharedData.appPath);

        File app = new File(appDir, SharedData.grasshopperVersion + ".apk");

        capabilities.setCapability("device", "Android");

        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("platformVersion", SharedData.phoneAndroidVersion);
        capabilities.setCapability("app", app.getAbsolutePath());
    }

    private static void setupEmulatorCapabilities(DesiredCapabilities capabilities, String emulatorName, String androidVersion) {
        capabilities.setCapability("avd", emulatorName);
        capabilities.setCapability("platformVersion", androidVersion);
    }

    /**
     * Sets up capabilities for running the script with restarting the same version of app etc/
     *
     * @param capabilities
     */
    private void setupRestartCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("noReset", true);
    }

    private static IOSDriver setupIOSCapabilities() throws MalformedURLException {

        // valid simulator capabilities
        File appDir = new File(SharedData.appPath);

        File app = new File(appDir, "Grasshopper" + ".ipa");

        DesiredCapabilities capabilitiesIOS = new DesiredCapabilities();
        capabilitiesIOS.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.1");
        capabilitiesIOS.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

        capabilitiesIOS.setCapability(MobileCapabilityType.UDID, "963ac0cfa755e8102b52ba78af046accec2d95d3");
        capabilitiesIOS.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

        capabilitiesIOS.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        capabilitiesIOS.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        return new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesIOS);
    }

    /**
     * Sets up emulator.
     *
     * @return
     */
    public static AndroidDriver SetupEmulator() {
        AndroidDriver driver = null;

        File appDir = new File(SharedData.appPath);

        File app = new File(appDir, "465.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");

        // TODO
        capabilities.setCapability("avd", "PixelAPI26");

        //TODO: TEMPORARY!
        //        capabilities.setCapability("fullReset", false);
        //        capabilities.setCapability("noReset", true);


        capabilities.setCapability("platformVersion", "8.0.0");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}
