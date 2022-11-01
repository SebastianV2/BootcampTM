package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AdminPage;
import pages.HomePage;
import utils.Constants;

public class AdminStepDefinition {

    private WebDriver driver = Hooks.driver;

    AdminPage adminPage = new AdminPage(driver);

    @Given("he selects Admin option")
    public void heSelectsAdminOption() {
        HomePage homePage = new HomePage(driver);
        homePage.selectAdmin();
    }

    @When("he searches an Admin by username")
    public void heSearchesAnAdminByUsername() {
        adminPage.searchAdminByUsername(Constants.Admin.name());
    }

    @When("he searches an Admin by employee name")
    public void heSearchesAnAdminByEmployeeName() {
        adminPage.searchAdminByEmployeeName(Constants.Garry.name());
    }

    @Then("he should see all the info of the admin")
    public void heShouldSeeAllTheInfoOfTheAdmin() {
        adminPage.userRoleIsDisplayed();
    }

}
