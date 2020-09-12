package store.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        plugin = {"pretty","json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/api_features",
        glue = "store/step_definitions",
        dryRun = false,
        tags = ""



)
public class Runner {
}

