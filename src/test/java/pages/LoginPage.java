package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    HomePage homePage = new HomePage(driver);

    @FindBy(name = "username")
    public WebElement usernameField;
    @FindBy(name = "password")
    public WebElement passwordField;
    @FindBy(xpath = "//button")
    public WebElement loginButton;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    public WebElement errorLabel;
    @FindBy(xpath = "//span[text()='Required']")
    public WebElement requiredLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void type(WebElement element, String value){
        element.sendKeys(value);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void login(String user, String pass){
        type(usernameField, user);
        type(passwordField, pass);
        clickOnLoginButton();
    }

    public void logout(){
        homePage.userDropdown.click();
        homePage.optLogout.click();
    }

    public Boolean wrongCredentials() { return errorLabel.isDisplayed(); }
    public Boolean emptyCredentials() { return requiredLabel.isDisplayed(); }
    public Boolean loginButton() { return loginButton.isDisplayed(); }
}
