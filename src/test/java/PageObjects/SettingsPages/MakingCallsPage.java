package PageObjects.SettingsPages;

import PageObjects.base.BasePage;
import helper.MakingCallsOption;
import helper.SharedData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;
import java.util.NoSuchElementException;

public class MakingCallsPage extends BasePage {
    public MakingCallsPage(AppiumDriver driver) {
        super(driver);
    }

    public final String[] MAKING_CALLS_OPTIONS = {"Use Grasshopper for In-App Calls Only", "Always Make Calls via Grasshopper", "Ask to Use Grasshopper for Each Call"};

    @AndroidFindBy(id = "com.grasshopper.dialer:id/listView")
    private MobileElement parentMakingCallsOptionsList;

    private List<MobileElement> makingCallsOptionsList = parentMakingCallsOptionsList.findElements(By.className("android.widget.RelativeLayout"));

    public final String PAGE_TITLE_TEXT = "Making Calls";

    public void refreshMakingCallsPage() {
        logger.debug("Refresh Making Calls option list");
        SharedData.makingCallsOptionsList.clear();

        for (MobileElement element : makingCallsOptionsList) {
            MakingCallsOption option = new MakingCallsOption(element);
            SharedData.makingCallsOptionsList.add(option);
        }
    }

    public MakingCallsOption selectMakingCallsOption(String optionName) {
        MakingCallsOption selectedOption = null;
        for (MakingCallsOption option : SharedData.makingCallsOptionsList) {
            if (option.getOptionName().equalsIgnoreCase(optionName)) {
                selectedOption = option;
                break;
            }
        }
        if (selectedOption == null) {
            logger.error(String.format("\"-%s\" Making Calls option doesn't exist",optionName));
            throw new NoSuchElementException("Making Calls option  doesn't exist");
        }
        return selectedOption;
    }

    public void clickMakingCallsOption(String optionName) {
        logger.info(String.format("Click \"-%s\" Making Calls option", optionName));
        selectMakingCallsOption(optionName).getOptionMobileElement().click();
    }

    public Boolean isMakingCallsOptionSelected(String optionName) {
        return selectMakingCallsOption(optionName).isOptionSelected();
    }

}
