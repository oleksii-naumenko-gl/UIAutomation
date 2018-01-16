package PageObjects;


import PageObjects.Web.helpers.CommonHelper;
import PageObjects.Web.helpers.DialerHelper;
import PageObjects.Web.helpers.LoginHelper;

public class GrasshopperWebApp {
    //    web pages
    public CommonHelper commonHelper() {
        return new CommonHelper();
    }

    public LoginHelper loginHelper() {
        return new LoginHelper();
    }
    public DialerHelper dialerHelper() {
        return new DialerHelper();
    }
}
