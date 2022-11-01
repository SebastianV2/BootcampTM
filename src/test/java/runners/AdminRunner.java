package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Admin.feature",
        glue = "stepdefinitions"
)
public class AdminRunner extends AbstractTestNGCucumberTests {
}
