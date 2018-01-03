package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "json:target/reports.json",
                "html:target/reports",
                "pretty"
        },
        features = "src/test/java/cucumber",
        glue = {"com.citrix.grasshopper.at.steps"},
        //tags = {"@accessNumber","@makingCalls"},
        strict = false
)
public class RunCucumberTest {


}