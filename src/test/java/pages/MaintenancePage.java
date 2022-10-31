package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaintenancePage extends BasePage{

    LoginPage loginPage = new LoginPage(driver);
    DirectoryPage directoryPage = new DirectoryPage(driver);

    @FindBy(xpath = "//button[text()=' Confirm ']")
    public WebElement confirmBtn;

    @FindBy(xpath = "//a[text()='Access Records']")
    public WebElement accessOpt;

    @FindBy(xpath = "//button[text()=' Download ']")
    public WebElement downloadButton;

    public MaintenancePage(WebDriver driver) {
        super(driver);
    }

    public void adminAccess(String pass){
        type(loginPage.passwordField, pass);
        click(confirmBtn);
    }

    public void searchEmployeeInfo(String name){
        click(accessOpt);
        directoryPage.searchForName(name);
    }

    public void downloadData(){
        click(downloadButton);
    }
}
