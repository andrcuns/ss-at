package lv.ss.at.cukes;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        runLevel = CourgetteRunLevel.SCENARIO,
        showTestOutput = true,
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/lv/ss/at/cukes/features",
                glue = "lv.ss.at.cukes.steps",
                tags = {"@all", "not @disabled"},
                strict = true
        ))
public class CukesParallelRunner {
}
