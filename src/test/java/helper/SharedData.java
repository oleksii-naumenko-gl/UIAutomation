package helper;

import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.Map;

public class SharedData {

    public static String appPath;

    public static String phoneAndroidVersion;

    public static String appiumServer;

    public static String grasshopperVersion;

    public static Map<Contact, MobileElement> favoritesMap = new HashMap<>();

}
