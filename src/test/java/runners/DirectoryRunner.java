package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Directory.feature",
        glue = "stepdefinitions"
)
public class DirectoryRunner extends AbstractTestNGCucumberTests {
}
