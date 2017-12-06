package PageObjects;

import PageObjects.dialogs.BaseAlert;
import PageObjects.dialogs.BaseDialog;
import PageObjects.dialogs.PermissionRequest;
import helper.SharedData;
import io.appium.java_client.android.AndroidDriver;
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

    public void endSession(){
        driver.quit();
        instance = null;
    }

    // Pages initialization
    public LoginPage loginPage(){
        return new LoginPage(driver);
    }

    public GetStartedPage getStartedPage() {
        return new GetStartedPage(driver);
    }

    public ExtensionSelectionScreen extensionSelectionScreen() { return new ExtensionSelectionScreen(driver); }

    public BaseActionPage bottomNavigationBar(){ return new BaseActionPage(driver); }

    public VOIPLoginPage voipLoginPage(){ return new VOIPLoginPage(driver); }

    public InboxPage inboxPage() { return new InboxPage(driver); }

    public RecentPage recentPage() { return new RecentPage(driver); }

    public CallPage callPage() { return new CallPage(driver); }

    public TextsPage textsPage() { return new TextsPage(driver); }

    public WifiCallPage wifiCallPage() { return new WifiCallPage(driver); }

    public FavoritesPage favoritesPage() { return new FavoritesPage(driver); }

    public SettingsScreen settingsScreen() {
        return new SettingsScreen(driver);
    }

    public CallForwardingSettingsPage callForwardingSettingsPage(){
        return new CallForwardingSettingsPage(driver);
    }

    public VoicemailDetails voicemailDetails() { return new VoicemailDetails(driver); }

    public ContactsPage contactsPage() { return new ContactsPage(driver); }

    public SingleContactPage singleContactPage() { return new SingleContactPage(driver); }

    public BaseDialog baseDialog(){ return new BaseDialog(driver); }

    public BaseAlert baseAlert() { return new BaseAlert(driver); }

    public PermissionRequest permissionRequest() {return new PermissionRequest(driver);}

    public static void getProperties(){
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

    public static AndroidDriver setup(String emulatorName, String androidVersion){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupBasicCapabilities(capabilities);
        setupEmulatorCapabilities(capabilities, emulatorName, androidVersion);

        return setupDriver(capabilities);
    }

    public static AndroidDriver setup(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupBasicCapabilities(capabilities);

        return setupDriver(capabilities);
    }

    /**
     * Setting up new instance of Appium Driver using
     * @param capabilities the capabilities to be used
     * @return new instance of Driver
     */
    private static AndroidDriver setupDriver(DesiredCapabilities capabilities){
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
     * @param capabilities
     */
    private static void setupBasicCapabilities(DesiredCapabilities capabilities){
        File appDir = new File(SharedData.appPath);

        File app = new File(appDir, SharedData.grasshopperVersion + ".apk");

        capabilities.setCapability("device", "Android");

        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("platformVersion", SharedData.phoneAndroidVersion);
        capabilities.setCapability("app", app.getAbsolutePath());
    }

    private static void setupEmulatorCapabilities(DesiredCapabilities capabilities, String emulatorName, String androidVersion){
        capabilities.setCapability("avd", emulatorName);
        capabilities.setCapability("platformVersion", androidVersion);
    }

    /**
     * Sets up capabilities for running the script with restarting the same version of app etc/
     * @param capabilities
     */
    private static void setupRestartCapabilities(DesiredCapabilities capabilities){
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("noReset", true);
    }

    /**
     * Sets up emulator.
     * @return
     */
    public static AndroidDriver SetupEmulator(){
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
}
