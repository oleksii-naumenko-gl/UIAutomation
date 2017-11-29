package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/cucumber/Settings1",
        glue = "com.citrix.grasshopper.at.steps",
        strict=true
)
public class RunCucumberTest {
}