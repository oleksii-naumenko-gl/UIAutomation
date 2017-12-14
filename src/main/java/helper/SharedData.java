package helper;

import io.appium.java_client.MobileElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SharedData {

    public static String appPath;

    public static String phoneAndroidVersion;

    public static String appiumServer;

    public static String grasshopperVersion;

    public static Map<Contact, MobileElement> favoritesMap = new HashMap<>();

    public static Map<RecentInboxEntry, MobileElement> inboxMap = new HashMap<>();

    public static Map<RecentInboxEntry, MobileElement> recentMap = new HashMap<>();

    public static List<TextsEntry> textsMap = new ArrayList<>();

    public static Map<NavigationTab, Integer>  unreadCounterMap = new HashMap<NavigationTab, Integer>();

    public static Map<String, Integer> textDropdownUnreadCounter = new HashMap<>();

   public static List<TextMessage> messagesList = new ArrayList<>();
}
