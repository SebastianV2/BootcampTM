package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PimPage;

public class PimStepDefinition {

    private WebDriver driver = Hooks.driver;

    PimPage pimPage = new PimPage(driver);

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

    @Then("he should see all the info of the new user")
    public void heShouldSeeAllTheInfoOfTheAdmin() {
        pimPage.personalDetailsLabelIsDisplayed();
    }

    @Then("he should see the required field label")
    public void heShouldSeeTheRequiredFieldLabel() {
        pimPage.emptyNameLabelIsDisplayed();
    }

}
