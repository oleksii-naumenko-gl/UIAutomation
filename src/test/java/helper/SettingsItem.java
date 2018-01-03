package helper;

public enum SettingsItem {
    CALL_FORWARDING("com.grasshopper.dialer:id/rl_settings_making_calls", "Call Forwarding"),
    WIFI_CALLING("com.grasshopper.dialer:id/rl_settings_calling_method", "WiFi Calling"),
    SYNC_AND_NOTIFICATION_SETTINGS("com.grasshopper.dialer:id/rl_sync_settings", "Sync & Notification Settings"),
    ACCESS_NUMBER("com.grasshopper.dialer:id/rl_settings_access_number", "Access Number"),
    MAKING_CALLS("com.grasshopper.dialer:id/rl_settings_making_calls", "Making Calls"),
    MY_EXTENSION("com.grasshopper.dialer:id/rl_my_extension_number", "My Extension"),
    MY_MOBILE_NUMBER("com.grasshopper.dialer:id/rl_my_mobile_number", "My Mobile Number"),
    CALLER_INFO("com.grasshopper.dialer:id/rl_settings_caller_info", "Caller Info"),
    BLOCKED_NUMBERS("com.grasshopper.dialer:id/rl_settings_caller_info", "Blocked Numbers"),
    GIVE_FEEDBACK("com.grasshopper.dialer:id/rl_settings_feedback", "Give Feedback"),
    ABOUT_GRASSHOPPER("com.grasshopper.dialer:id/rl_settings_about", "About Grasshopper");

    private String id;

    private String text;

    SettingsItem(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
