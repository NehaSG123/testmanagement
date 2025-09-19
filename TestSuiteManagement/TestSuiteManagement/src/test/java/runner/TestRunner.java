package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
   features = "classpath:features"
    glue = {"stepdefinitions"},
    plugin = {"pretty","json:target/cucumber.json","html:target/cucumber-report.html"}
)

public class TestRunner {
}


