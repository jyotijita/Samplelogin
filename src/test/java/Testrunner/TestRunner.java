package Testrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"Stedefinition"},
        plugin = {"pretty","junit:target/JUnitReports/report.xml","json:target/JSONReports/report.json",
                "html:target/HTMLReports"},
        tags="@WrongUsernameScenario")
public class TestRunner {

}
