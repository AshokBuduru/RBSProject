package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = {"src/main/resources/features"},
        glue={"classpath:StepDefinitions"},
        monochrome = true,
        tags = {"@regression"}
)
public class testRunner {
}
