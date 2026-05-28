package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {

        LoginPage lp = new LoginPage(driver);

        lp.loginApplication();
    }
}