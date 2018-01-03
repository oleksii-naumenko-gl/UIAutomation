package helper;

public enum NavigationTab {
    INBOX(0, "Inbox"),
    RECENT(1, "Recent"),
    CALL(2, "Call"),
    TEXTS(3, "Texts"),
    SETTINGS(4, "Settings");

    private int value;

    private String text;

    private NavigationTab(int value, String text){
        this.value = value;
        this.text = text;
    }

    public int getValue(){
        return value;
    }

    public String getText(){
        return text;
    }
}
