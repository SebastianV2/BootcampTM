package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//p[text()='OrangeHRM']")
    public WebElement companyNameLabel;
    @FindBy(xpath = "//p[text()='Customer Support']")
    public WebElement customerSupportLabel;
    @FindBy(xpath = "//span[contains(@class, 'userdropdown')]")
    public WebElement userDropdown;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement optLogout;
    @FindBy(xpath = "//a[text()='About']")
    public WebElement optAbout;
    @FindBy(xpath = "//a[text()='Support']")
    public WebElement optSupport;
    @FindBy(xpath = "//img[@alt='profile picture']")
    public WebElement profilePicture;

    public WebElement menuOption(String opt){
        return driver.findElement(By.xpath("//span[text()='"+ opt +"']"));
    }

    public void selectDirectory(){
        click(menuOption("Directory"));
    }

    public void selectMaintenance(){
        click(menuOption("Maintenance"));
    }

    public void selectMyInfo(){
        click(menuOption("My Info"));
    }

    public void selectAdmin(){
        click(menuOption("Admin"));
    }

    public void selectAboutOption(){
        click(userDropdown);
        click(optAbout);
    }

    public void selectSupportOption(){
        click(userDropdown);
        click(optSupport);
    }

    public Boolean isOnHomePage() {
        return profilePicture.isDisplayed();
    }

    public Boolean theCompanyNameIsDisplayed(){
        return companyNameLabel.isDisplayed();
    }

    public Boolean theCustomerSupportInfoIsDisplayed(){
        return customerSupportLabel.isDisplayed();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
