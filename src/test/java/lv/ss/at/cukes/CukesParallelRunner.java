package lv.ss.at.cukes;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        runLevel = CourgetteRunLevel.FEATURE,
        showTestOutput = true,
        reportTargetDir = "build/reports",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/lv/ss/at/cukes/features",
                glue = "classpath:lv/ss/at/cukes/steps",
                tags = "not @disabled",
                plugin = {
                        "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                        "json:build/reports/cucumber-report/cucumber.json",
                },
                strict = true
        ))
public class CukesParallelRunner {
}
