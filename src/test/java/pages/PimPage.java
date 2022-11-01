package pages;

import models.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.Builder.*;

public class PimPage extends BasePage{

    private final UserModel basicUser = buildBasicUser();
    private final UserModel user = buildUserWithLoginInfo();
    private final UserModel wUser = buildUserWithWrongData();

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addBtn;
    @FindBy(name = "firstName")
    public WebElement  firstName;
    @FindBy(name = "lastName")
    public WebElement  lastName;
    @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    public WebElement  createDetails;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    public WebElement  username;
    @FindBy(css = "input[type='password']")
    public List<WebElement> password;
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveBtn;
    @FindBy(xpath = "//h6[text()='Personal Details']")
    public WebElement personalDetailsLabel;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement requiredNameLabel;

    public void createUserWithoutLoginInfo(){
        PimPage pimPage = new PimPage(driver);
        createBasicUser(pimPage, basicUser);
    }

    public void createUserWithLoginInfo(){
        PimPage pimPage = new PimPage(driver);
        createUser(pimPage, user);
    }

    public void createUserWithEmptyName(){
        PimPage pimPage = new PimPage(driver);
        createWuser(pimPage, wUser);
    }

    public Boolean personalDetailsLabelIsDisplayed(){
        return personalDetailsLabel.isDisplayed();
    }

    public Boolean emptyNameLabelIsDisplayed(){
        return requiredNameLabel.isDisplayed();
    }

    public PimPage(WebDriver driver) {
        super(driver);
    }
}
