package helper;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ForwardingNumber {

    private String numberId = "com.grasshopper.dialer:id/number";
    private String checkboxId = "com.grasshopper.dialer:id/checkbox";
    private String number;
    private Boolean statusOfCheckbox;
    private MobileElement numberMobileElement;
    private MobileElement checkboxMobileElement;
    private MobileElement mobileElement;

    public ForwardingNumber(MobileElement element) {
        this.mobileElement = element;

        numberMobileElement = mobileElement.findElement(By.id(numberId));
        number = numberMobileElement.getText();
        checkboxMobileElement = mobileElement.findElement(By.id(checkboxId));
        statusOfCheckbox = Boolean.getBoolean(element.findElement(By.id("com.grasshopper.dialer:id/checkbox")).getAttribute("checked"));
    }

    public String getNumber() {
        return modifyFormattedNumber(number);
    }

    public Boolean getStatusOfCheckbox() {
        return statusOfCheckbox;
    }

    public MobileElement getNumberMobileElement() {
        return numberMobileElement;
    }

    public MobileElement getCheckboxMobileElement() {
        return checkboxMobileElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForwardingNumber that = (ForwardingNumber) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return statusOfCheckbox != null ? statusOfCheckbox.equals(that.statusOfCheckbox) : that.statusOfCheckbox == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (statusOfCheckbox != null ? statusOfCheckbox.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ForwardingNumber{" +
                ", number='" + number + '\'' +
                ", statusOfCheckbox=" + statusOfCheckbox +
                ", numberMobileElement=" + numberMobileElement +
                ", checkboxMobileElement=" + checkboxMobileElement +
                '}';
    }

    public static String modifyFormattedNumber(String originalNumber) {
        return originalNumber.replaceAll("[^0-9]", "");
    }
}
