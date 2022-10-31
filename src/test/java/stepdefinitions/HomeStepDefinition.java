package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomeStepDefinition {

    private WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);

    @When("he gets into about option")
    public void heGetsIntoAboutOption() {
        homePage.selectAboutOption();
    }

    @Then("he should see about information of the page")
    public void heShouldSeeAboutInformationOfThePage() {
        homePage.theCompanyNameIsDisplayed();
    }

    @When("he gets into support option")
    public void heGetsIntoSupportOption() {
        homePage.selectSupportOption();
    }

    @Then("he should see the customer support information")
    public void heShouldSeeTheCustomerSupportInformation() {
        homePage.theCustomerSupportInfoIsDisplayed();
    }
}
