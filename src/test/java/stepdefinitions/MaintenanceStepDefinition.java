package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.MaintenancePage;
import utils.Constants;

public class MaintenanceStepDefinition {

    private WebDriver driver = Hooks.driver;

    MaintenancePage maintenancePage = new MaintenancePage(driver);

    @Given("he selects Maintenance option")
    public void heSelectsMaintenanceOption() {
        HomePage homePage = new HomePage(driver);
        homePage.selectMaintenance();
    }

    @When("he enters the password and searches an employee data")
    public void heEntersThePasswordAndSearchesAnEmployeeData() {
        maintenancePage.adminAccess(Constants.admin123.name());
        maintenancePage.searchEmployeeInfo(Constants.Peter.name());
    }

    @Then("he can download the employee data")
    public void heShouldSeeTheDownloadedFile() {
        maintenancePage.downloadData();
    }

}
