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

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button")
    public WebElement addButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input")
    public WebElement name;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input")
    public WebElement relationship;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input")
    public WebElement mobile;

    @FindBy(xpath = "//button[(text()=' Save ')]")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div[2]/div/div/div[7]/div/button[1]")
    public WebElement deleteBtn;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    public WebElement confirmDeleteBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/span']")
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
