package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Maintenance.feature",
        glue = "stepdefinitions"
)
public class MaintenanceRunner extends AbstractTestNGCucumberTests {
}
