package lv.ss.at.cukes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/lv/ss/at/cukes/features",
        glue = "lv.ss.at.cukes.steps",
        tags = {"@all", "not @disabled"},
        strict = true
)
public class CukesRunner {
}
