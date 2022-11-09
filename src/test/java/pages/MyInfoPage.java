package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyInfoPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'employee-name')]")
    public WebElement employeeName;

    @FindBy(xpath = "//a[(text()='Emergency Contacts')]")
    public WebElement emergencyContactOpt;

    @FindBy(xpath = "//h6[text()='Assigned Emergency Contacts']/following-sibling::button")
    public WebElement addButton;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    public WebElement name;

    @FindBy(xpath = "//label[text()='Relationship']/parent::div/following-sibling::div/input")
    public WebElement relationship;

    @FindBy(xpath = "//label[text()='Mobile']/parent::div/following-sibling::div/input")
    public WebElement mobile;

    @FindBy(xpath = "//button[(text()=' Save ')]")
    public WebElement saveBtn;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    public WebElement confirmDeleteBtn;

    @FindBy(xpath = "//span[text()='No Records Found']")
    public WebElement noRecordsLabel;

    public void getName(){
        WaitUntilElementVisible(employeeName);
    }

    public void checkName(){
        Assert.assertTrue(employeeName.isDisplayed());
    }

    public void addEmergencyContact(String contactName, String contactRelationship, String contactNumber){
        click(emergencyContactOpt);
        click(addButton);
        type(name, contactName);
        type(relationship, contactRelationship);
        type(mobile, contactNumber);
        click(saveBtn);
    }

    public void deleteEmergencyContact(){
        click(deleteBtn);
        click(confirmDeleteBtn);
    }

    public Boolean deleteButton(){
        return deleteBtn.isDisplayed();
    }

    public Boolean noRecords(){
        return noRecordsLabel.isDisplayed();
    }

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }
}
