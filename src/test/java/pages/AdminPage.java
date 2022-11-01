package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage{

    DirectoryPage directoryPage = new DirectoryPage(driver);

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    public WebElement usernameField;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[text()='Enabled']")
    public WebElement userRoleLabel;

    public void searchAdminByUsername(String user){
        type(usernameField, user);
        click(searchBtn);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchAdminByEmployeeName(String name){
        directoryPage.searchForName(name);
    }

    public Boolean userRoleIsDisplayed(){
        return userRoleLabel.isDisplayed();
    }

    public AdminPage(WebDriver driver) {
        super(driver);
    }
}