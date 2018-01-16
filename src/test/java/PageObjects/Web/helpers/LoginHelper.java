package PageObjects.Web.helpers;

import PageObjects.Web.pages.LoginWebPage;
import helper.DefaultUser;

public class LoginHelper extends LoginWebPage {

    public final String ALERT_ERROR_MESSAGE = "Incorrect user id or password.";

    public void logInDefauultUser() {
        login(DefaultUser.login, DefaultUser.password);
    }

    public void logInAnyUser(String loginName, String password) {
        login(loginName, password);
    }

    public String getAlert(){
        return getErrorMessageText();
    }
}
