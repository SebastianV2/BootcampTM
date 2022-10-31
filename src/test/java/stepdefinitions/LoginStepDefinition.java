package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.Constants;

public class LoginStepDefinition {

    private WebDriver driver = Hooks.driver;

    private String url = Hooks.url;

    LoginPage loginPage = new LoginPage(driver);

    @Given("the user navigates to OrangeHRM")
    public void theUserNavigatesToOrangeHRM() {
        driver.get(url);
    }

    @Given("the user is on OrangeHRM homepage")
    public void theUserIsOnOrangeHRMHomepage() {
        theUserNavigatesToOrangeHRM();
        heFillsUsernameAndPassword();
    }
    @When("he fills username and password")
    public void heFillsUsernameAndPassword() {
        loginPage.login(Constants.Admin.name(), Constants.admin123.name());
    }
    @Then("he should see the homepage")
    public void heShouldSeeTheHomepage() {
        loginPage.isOnHomePage();
    }

    @When("he fills username and password with wrong credentials")
    public void heFillsUsernameAndPasswordWithWrongCredentials() {
        loginPage.login(Constants.User1.name(), Constants.user1.name());
    }

    @Then("he should see the wrong credentials error message")
    public void heShouldSeeTheWrongCredentialsErrorMessage() {
        loginPage.wrongCredentials();
    }

    @When("he fills only the password")
    public void heFillsOnlyThePassword() {
        loginPage.login("", Constants.admin123.name());
    }

    @When("he fills only the username")
    public void heFillsOnlyTheUsername() {
        loginPage.login(Constants.Admin.name(), "");
    }

    @Then("he should see the required field error message")
    public void heShouldSeeTheRequiredFieldErrorMessage() {
        loginPage.emptyCredentials();
    }

    @When("he close his session")
    public void heCloseHisSession() {
        loginPage.logout();
    }

    @Then("he should see the login page")
    public void heShouldSeeTheLoginPage() {
        loginPage.loginButton();
    }
}
