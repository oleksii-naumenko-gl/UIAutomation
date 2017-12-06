package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/cucumber/Settings1_IncomingCalls.feature",
        glue = {"com.citrix.grasshopper.at.steps"},
        //tags = {"@Settings"},
        strict = false
)
public class RunCucumberTest {
}