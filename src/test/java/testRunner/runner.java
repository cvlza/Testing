package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src//test//resources//features",
        glue = {"stepDefinition"},
        monochrome = true,
//        tags = "@Smoke",
//        tags ="@Smoke and @Regression",
//        tags = "@Smoke or @Regression",
//        tags = "not @Fail",
        tags = "@Test",
        plugin = {"pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)

public class runner {

}


