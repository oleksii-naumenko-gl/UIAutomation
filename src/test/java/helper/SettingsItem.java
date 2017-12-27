package helper;

public enum SettingsItem {
    CALL_FORWARDING("com.grasshopper.dialer:id/tv_call_forwarding_id", "Call Forwarding"),
    WIFI_CALLING("com.grasshopper.dialer:id/tv_calling_method", "WiFi Calling"),
    SYNC_AND_NOTIFICATION_SETTINGS("com.grasshopper.dialer:id/tv_sync_settings_text", "Sync & Notification Settings"),
    ACCESS_NUMBER("com.grasshopper.dialer:id/tv_access_number", "Access Number"),
    MAKING_CALLS("com.grasshopper.dialer:id/tv_making_call", "Making Calls"),
    MY_EXTENSION("com.grasshopper.dialer:id/my_extension_number", "My Extension"),
    MY_MOBILE_NUMBER("com.grasshopper.dialer:id/my_mobile_number", "My Mobile Number"),
    BLOCKED_NUMBERS("com.grasshopper.dialer:id/blocknumber_title", "Blocked Numbers"),
    GIVE_FEEDBACK("com.grasshopper.dialer:id/rl_settings_feedback", "Give Feedback"),
    ABOUT_GRASSHOPPER("com.grasshopper.dialer:id/rl_settings_about", "About Grasshopper");

    private String id;

    private String text;

    SettingsItem(String id, String text){
        this.id = id;
        this.text = text;
    }


    public String getId(){
        return id;
    }

    public String getText(){
        return text;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
