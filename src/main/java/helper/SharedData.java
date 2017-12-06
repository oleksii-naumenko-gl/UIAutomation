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

    public static Map<RecentInboxEntry, MobileElement> inboxMap = new HashMap<>();

    public static Map<RecentInboxEntry, MobileElement> recentMap = new HashMap<>();

    public static Map<TextsEntry, MobileElement> textsMap = new HashMap<>();
}
