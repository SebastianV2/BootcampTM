package pages;

import models.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

import java.util.List;

import static utils.Builder.*;

public class PimPage extends BasePage{

    private final UserModel basicUser = buildBasicUser();
    private final UserModel user = buildUserWithLoginInfo();
    private final UserModel wUser = buildUserWithWrongData();
    DirectoryPage directoryPage = new DirectoryPage(driver);

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addBtn;
    @FindBy(name = "firstName")
    public WebElement  firstName;
    @FindBy(name = "middleName")
    public WebElement  middleName;
    @FindBy(name = "lastName")
    public WebElement  lastName;
    @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    public WebElement  createDetails;
    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
    public WebElement  username;
    @FindBy(css = "input[type='password']")
    public List<WebElement> password;
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveBtn;
    @FindBy(xpath = "//h6[text()='Personal Details']")
    public WebElement personalDetailsLabel;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement requiredNameLabel;
    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    public WebElement employeeId;
    @FindBy(xpath = "//div[text()='QA Engineer']")
    public WebElement jobTitle;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;
    @FindBy(xpath = "//a[text()='Reports']")
    public WebElement reportsOpt;
    @FindBy(xpath = "//a[text()='Employee List']")
    public WebElement employeeListOpt;
    @FindBy(xpath = "//span[text()='(1) Record Found']")
    public WebElement searchResult;
    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    public WebElement editBtn;
    @FindBy(xpath = "//div[contains(text(),'Fiona')]")
    public WebElement firstNameTable;

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

    public void searchForEmployeeId(String id){
        type(employeeId, id);
        click(searchButton);
    }

    public void searchReport(){
        click(reportsOpt);
        directoryPage.searchForName(Constants.PIM.name());
    }

    public void editEmployeeName(){
        searchForEmployeeId("0029");
        click(editBtn);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        type(middleName,"Berlin");
        click(saveBtn);
    }

    public Boolean checkName(){
        click(employeeListOpt);
        type(employeeId, "0029");
        click(searchButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return firstNameTable.getText().contains("Berlin");
    }

    public Boolean getSearchResults(){
        return searchResult.getText().equalsIgnoreCase("(1) Record Found");
    }

    public Boolean getJobTitle(){
        return jobTitle.getText().equalsIgnoreCase("QA Enginner");
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
