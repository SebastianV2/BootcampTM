package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public WebElement menuOption(String opt){
        return driver.findElement(By.xpath("//span[text()='"+ opt +"']"));
    }

    public void directory(){
        click(menuOption("Directory"));
    }

    public void maintenance(){
        click(menuOption("Maintenance"));
    }

    public void myInfo(){
        click(menuOption("My Info"));
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
