package helper;

public enum RecentDropdownValue {

    ALLCALSS(0, "All Calls"),
    MISSED(1, "Missed"),
    RECEIVED(2, "Received"),
    DIALED(3, "Dialed");

    private int value;

    private String text;

    private RecentDropdownValue(int value, String text){
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
