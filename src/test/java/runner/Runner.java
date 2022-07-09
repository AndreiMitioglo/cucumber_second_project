package runner;
// Class Used to run suites of tests
import cucumber.api.CucumberOptions; // from cucumber api library
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// Class Used to run suites of tests Regression and Suites

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // copy path of features folder
        glue = "steps",
        tags = "@Smoke", // empty - "" - will run all test cases in the feature google.file
        dryRun = false,
        monochrome = false, // makes run terminal one color(no colors)
        plugin = {"html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json",
                "pretty"
        })


public class Runner {



}



