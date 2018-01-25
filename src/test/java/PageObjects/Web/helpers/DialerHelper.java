package PageObjects.Web.helpers;

import PageObjects.Web.pages.DialerWebPage;

public class DialerHelper  extends DialerWebPage {

    public String getUserName(){

        return getUserNameText();
    }

    public Boolean isDialerPresent(){
        return isDialerDisplayed();
    }
}
