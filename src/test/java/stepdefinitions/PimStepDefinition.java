package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.PimPage;

public class PimStepDefinition {

    private WebDriver driver = Hooks.driver;

    PimPage pimPage = new PimPage(driver);

    @Given("he selects PIM option")
    public void heSelectsMyInfoOption() {
        HomePage homePage = new HomePage(driver);
        homePage.selectPim();
    }

    @When("he creates a basic user")
    public void heCreatesABasicUser() {
        pimPage.createUserWithoutLoginInfo();
    }

    @When("he creates an user with login info")
    public void heCreatesAnUserWithLoginInfo() {
        pimPage.createUserWithLoginInfo();
    }

    @When("he creates an user with empty name")
    public void heCreatesAnUserWithEmptyName() {
        pimPage.createUserWithEmptyName();
    }

    @When("he searches an employee for his Id number")
    public void heSearchesAnEmployeeForHisIdNumber() {
        pimPage.searchForEmployeeId("0042");
    }

    @When("he searches for a report by name")
    public void heSearchesForAReportByName() {
        pimPage.searchReport();
    }

    @When("he edits the name of an employee")
    public void heEditsTheNameOfAnEmployee() {
        pimPage.editEmployeeName();
    }

    @Then("he should see all the info of the new user")
    public void heShouldSeeAllTheInfoOfTheAdmin() {
        pimPage.personalDetailsLabelIsDisplayed();
    }

    @Then("he should see the required field label")
    public void heShouldSeeTheRequiredFieldLabel() {
        pimPage.emptyNameLabelIsDisplayed();
    }

    @Then("he should see the info of the employee")
    public void heShouldSeeTheInfoOfTheEmployee() {
        pimPage.getJobTitle();
    }

    @Then("he should see the desired report")
    public void heShouldSeeTheDesiredReport() {
        pimPage.getSearchResults();
    }

    @Then("he should see the new employees name")
    public void heShouldSeeTheNewEmployeesName() {
        pimPage.checkName();
    }

}
