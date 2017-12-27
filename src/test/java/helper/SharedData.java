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

    public static List<ForwardingNumber> forwardingNumberList = new ArrayList<>();

    public static List<AccessNumberOption> accessNumberOptionsList = new ArrayList<>();

    public static List<MakingCallsOption> makingCallsOptionsList = new ArrayList<>();

}
