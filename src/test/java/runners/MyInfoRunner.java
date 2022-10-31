package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/MyInfo.feature",
        glue = "stepdefinitions"
)
public class MyInfoRunner extends AbstractTestNGCucumberTests {
}
