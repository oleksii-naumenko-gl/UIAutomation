package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/",
        glue = {"com.citrix.grasshopper.at.steps"},
        tags = {"@Texts"},
        strict = false
)
public class RunCucumberTest {
}