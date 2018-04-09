package lv.ss.at.cukes;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        showTestOutput = true,
        cucumberOptions = @CucumberOptions(
                features = "classpath:lv/ss/at/cukes/features",
                glue = "classpath:lv/ss/at/cukes/steps",
                tags = {"@all", "not @disabled"},
                plugin = {
                        "pretty",
                        "json:build/cucumber/cucumber.json",
                        "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"
                },
                strict = true
        ))
public class CukesRunner {
}
