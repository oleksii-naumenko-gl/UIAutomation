package helper;

public class ForwardingNumber {

    private String number;
    private Boolean statusOfCheckbox;

    public ForwardingNumber(String number, Boolean statusOfCheckbox) {
        this.number = number;
        this.statusOfCheckbox = statusOfCheckbox;
    }

    public String getNumber() {
        return number;
    }

    public Boolean getStatusOfCheckbox() {
        return statusOfCheckbox;
    }
}
