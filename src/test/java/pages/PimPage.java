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
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    public WebElement employeeId;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[5]/div")
    public WebElement jobTitle;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;
    @FindBy(xpath = "//a[text()='Reports']")
    public WebElement reportsOpt;
    @FindBy(xpath = "//a[text()='Employee List']")
    public WebElement employeeListOpt;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    public WebElement searchResult;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]")
    public WebElement editBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div")
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
        return jobTitle.getText().equalsIgnoreCase("QA Lead");
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
