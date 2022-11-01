package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Pim.feature",
        glue = "stepdefinitions"
)
public class PimRunner extends AbstractTestNGCucumberTests {
}
