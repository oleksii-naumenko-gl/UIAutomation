package helper;

public enum InboxDropdownValue {

    INBOX(0, "Inbox"),
    VOICEMAILS(1, "Voicemails"),
    FAXES(2, "Faxes"),
    DELETED(3, "Deleted");

    private int value;

    private String text;

    private InboxDropdownValue(int value, String text){
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
