package helper;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Base class for Calls Settings Options
 */
public abstract class AbstractCallsSettingsOption {

    private String optionName;
    private Boolean isCheckboxExisted;
    private MobileElement optionMobileElement;

    public AbstractCallsSettingsOption(MobileElement element) {
        String optionId = "com.grasshopper.dialer:id/title";
        String checkboxId = "com.grasshopper.dialer:id/checkbox";

        optionMobileElement = element.findElement(By.id(optionId));
        optionName = optionMobileElement.getText();
        try {
            isCheckboxExisted = element.findElement(By.id(checkboxId)).isEnabled();
        }catch(Exception e){
            isCheckboxExisted = false;
        }
    }

    public String getOptionName() {
        return optionName;
    }

    public MobileElement getOptionMobileElement() {
        return optionMobileElement;
    }

    public Boolean isOptionSelected() {
        return isCheckboxExisted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCallsSettingsOption that = (AbstractCallsSettingsOption) o;

        if (optionName != null ? !optionName.equals(that.optionName) : that.optionName != null) return false;
        return isCheckboxExisted != null ? isCheckboxExisted.equals(that.isCheckboxExisted) : that.isCheckboxExisted == null;
    }

    @Override
    public int hashCode() {
        int result = optionName != null ? optionName.hashCode() : 0;
        result = 31 * result + (isCheckboxExisted != null ? isCheckboxExisted.hashCode() : 0);
        return result;
    }
}


