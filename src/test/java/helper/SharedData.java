package helper;

import io.appium.java_client.MobileElement;

import java.util.*;

public class SharedData {

    public static final String  BASE_URL="https://webclient.ghuser.com/webclient/";

    public static String appPath;

    public static String phoneAndroidVersion;

    public static String appiumServer;

    public static String grasshopperVersion;

    public static Map<Contact, MobileElement> favoritesMap = new HashMap<>();

    public static List<Extension> availableExtensionList = new ArrayList<>();

    public static List<ForwardingNumber> forwardingNumberList = new ArrayList<>();

    public static List<AccessNumberOption> accessNumberOptionsList = new ArrayList<>();

    public static List<MakingCallsOption> makingCallsOptionsList = new ArrayList<>();

    public static List<Extension> myExtensionSettingsList = new ArrayList<>();

    public static List<RecentInboxEntry> inboxMap = new ArrayList<>();

    public static List<RecentInboxEntry> deletedInboxMap = new ArrayList<>();

    public static Map<RecentInboxEntry, MobileElement> recentMap = new HashMap<>();

    public static List<TextsEntry> textsMap = new ArrayList<>();

    public static Map<NavigationTab, Integer>  unreadCounterMap = new HashMap<NavigationTab, Integer>();

    public static Map<String, Integer> textDropdownUnreadCounter = new HashMap<>();

    public static List<TextMessage> messagesList = new ArrayList<>();
}
