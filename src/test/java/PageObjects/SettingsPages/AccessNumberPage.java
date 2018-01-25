package PageObjects.SettingsPages;

import PageObjects.base.BasePage;
import helper.AccessNumberOption;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class AccessNumberPage extends BasePage {
    public AccessNumberPage(AppiumDriver driver) {
        super(driver);
    }

    public final String PAGE_TITLE = "Access Number";

    public final String PAGE_DESCRIPTION_TEXT = "Change your access number to a US local number to make calls from outside North America. International rates will apply.";

    public final String[] ACCESS_NUMBER_OPIONS = {"Default", "Local", "Toll free"};

    @AndroidFindBy(id = "com.grasshopper.dialer:id/description")
    private MobileElement pageDescription;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/plus_one")
    private MobileElement usePlusOneWhileDialing;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/plus_one_switch_button")
    private MobileElement switchButton;

    @AndroidFindBy(id = "com.grasshopper.dialer:id/access_number_list")
    private MobileElement parentAccessNumberOptions;

    private List<MobileElement> optionsList = parentAccessNumberOptions.findElementsByClassName("android.widget.RelativeLayout");

    public String getPageDescriptionText() {
        return pageDescription.getText();
    }

    public void switchUsePlusOneWhileDialing() {
        switchButton.click();
    }

    public Boolean getSwitchButtonState() {
        Boolean state = false;
        if (switchButton.getAttribute("text").equalsIgnoreCase("ON")) {
            state = true;
        }
        return state;
    }

    public Boolean isSwitchTurnedOn() {
        return getSwitchButtonState();
    }

    public void refreshAccessNumberPage() {
        logger.debug("Refresh Access Number option list");
        SharedData.accessNumberOptionsList.clear();


        for (MobileElement element : optionsList) {
            AccessNumberOption option = new AccessNumberOption(element);
            SharedData.accessNumberOptionsList.add(option);
        }
    }

    public AccessNumberOption selectAccessNumberOption(String optionName) {
        AccessNumberOption selectedOption = null;
        for (AccessNumberOption option : SharedData.accessNumberOptionsList) {
            if (option.getOptionName().equalsIgnoreCase(optionName)) {
                selectedOption = option;
                break;
            }
        }
        if (selectedOption==null) {
            logger.error(String.format("\"-%s\" Access Number option doesn't exist",optionName));
                throw new NoSuchElementException("Access Number option doesn't exist");
        }
        return selectedOption;
    }

    public void clickAccessNumberOption(String optionName) {
        logger.info(String.format("Click \"-%s\" Access Number option", optionName));
        selectAccessNumberOption(optionName).getOptionMobileElement().click();
    }

    public Boolean isAccessNumberOptionSelected(String optionName){
        return selectAccessNumberOption(optionName).isOptionSelected();
    }

}
