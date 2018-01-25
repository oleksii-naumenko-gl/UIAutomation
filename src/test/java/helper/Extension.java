package helper;

import io.appium.java_client.MobileElement;

import java.util.List;

import static helper.DefaultUser.extensions;

public class Extension {


    private String extDescription;

    private String extNumber;

    private int forwardingNumberCounter;

    private MobileElement element;

    // todo
    private boolean isMain;

    // todo List
    public String forwardingNumber = "";

    public List<String> forwardingNumbers;

    public int availableNumbers = 0;

    public Extension(String extDescription, String extNumber, int forwardingNumberCounter) {
        this.extDescription = extDescription;
        this.extNumber = extNumber;
        this.forwardingNumberCounter = forwardingNumberCounter;
    }

    public Extension(String extDescription, String extNumber) {
        this.extDescription = extDescription;
        this.extNumber = extNumber;
    }
    public Extension(MobileElement element){

    }

    public Extension(String extDescription, String extNumber, boolean isCheckboxExisted, MobileElement element) {
        this.extDescription = extDescription;
        this.extNumber = extNumber;
        this.isMain = isCheckboxExisted;
        this.element = element;
    }

    public String getExtDescription() {
        return extDescription;
    }

    public String getExtNumber() {
        return extNumber;
    }

    public int getForwardingNumberCounter() {
        return forwardingNumberCounter;
    }

    public boolean isMain() {
        return isMain;
    }

    public MobileElement getExtMobileElement() {
        return element;
    }

    public static String getExtensionName(String extDescription) {
        String extensionName = "";
        for (int index = 0; index < extensions.length; index++) {
            if (extDescription.equalsIgnoreCase(extensions[index].extNumber)) {
                extensionName = extensions[index].extDescription;
            }
        }
        return extensionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Extension extension = (Extension) o;

        if (extDescription != null ? !extDescription.equals(extension.extDescription) : extension.extDescription != null)
            return false;
        return extNumber != null ? extNumber.equals(extension.extNumber) : extension.extNumber == null;
    }

    @Override
    public int hashCode() {
        int result = extDescription != null ? extDescription.hashCode() : 0;
        result = 31 * result + (extNumber != null ? extNumber.hashCode() : 0);
        return result;
    }
}