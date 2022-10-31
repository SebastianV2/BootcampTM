package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DirectoryPage;
import pages.HomePage;
import utils.Constants;

public class DirectoryStepDefinition {

    private WebDriver driver = Hooks.driver;
    DirectoryPage directoryPage = new DirectoryPage(driver);

    @Given("he selects Directory option")
    public void heSelectsDirectoryOption() {
        HomePage homePage = new HomePage(driver);
        homePage.directory();
    }

    @When("he searches for an employees name")
    public void heSearchesForAnEmployeeName() {
        directoryPage.searchForName(Constants.Peter.name());
    }

    @Then("he should see one search result")
    public void heShouldSeeOneResult() {
        directoryPage.searchResult();
    }

}
