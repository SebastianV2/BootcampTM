package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.MyInfoPage;
import utils.Constants;

public class MyInfoStepDefinition {

    private WebDriver driver = Hooks.driver;

    MyInfoPage myInfoPage = new MyInfoPage(driver);

    @Given("he selects My info option")
    public void heSelectsMyInfoOption() {
        HomePage homePage = new HomePage(driver);
        homePage.selectMyInfo();
    }

    @When("he reviews his personal information in the page")
    public void heReviewsHisPersonalInformationInThePage() {
        myInfoPage.getName();
    }

    @Then("he should see his name on top of the form")
    public void heShouldSeeHisNameOnTopOfTheForm() {
        myInfoPage.checkName();
    }

    @When("he adds a new emergency contact")
    public void heAddsANewEmergencyContact() {
        myInfoPage.addEmergencyContact(Constants.Sebas.name(), Constants.Cousin.name(), "3153134278");
    }

    @Then("he should see the new contact in the list")
    public void heShouldSeeTheNewContactInTheList() {
        myInfoPage.deleteButton();
    }

    @When("he deletes an emergency contact")
    public void heDeletesAnEmergencyContact() {
        myInfoPage.addEmergencyContact(Constants.Sebas.name(), Constants.Cousin.name(), "3153134278");
        myInfoPage.deleteEmergencyContact();
    }

    @Then("he should not see any emergency contacts")
    public void heShouldNotSeeAnyEmergencyContacts() {
        myInfoPage.noRecords();
    }
}
