package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage extends BasePage {

    @FindBy(xpath = "//input[contains(@placeholder,'Type')]")
    public WebElement employeeNameField;

    @FindBy(xpath = "//div[@role='listbox']")
    public WebElement autocompleteName;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()='(1) Record Found']")
    public WebElement searchLabel;

    public void searchForName(String name){
        type(employeeNameField, name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        autocompleteName.click();
        searchButton.click();
    }

    public DirectoryPage(WebDriver driver) {
        super(driver);
    }

    public Boolean searchResult(){ return searchLabel.isDisplayed(); }
}
