package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Constants;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.Admin.toString(), Constants.admin123.toString());
        Assert.assertTrue(loginPage.isOnHomePage());
    }
    @Test
    public void loginWithWrongCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.User1.toString(), Constants.user1.toString());
        Assert.assertTrue(loginPage.wrongCredentials());
    }
    @Test
    public void loginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", Constants.admin123.toString());
        Assert.assertTrue(loginPage.emptyCredentials());
    }
    @Test
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.Admin.toString(), "");
        Assert.assertTrue(loginPage.emptyCredentials());
    }
    @Test
    public void logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginWithValidCredentials();
        loginPage.logout();
        Assert.assertTrue(loginPage.loginButton());
    }
}
