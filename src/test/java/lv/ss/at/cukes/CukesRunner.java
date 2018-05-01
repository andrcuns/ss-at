package lv.ss.at.cukes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/lv/ss/at/cukes/features",
        glue = "lv.ss.at.cukes.steps",
        tags = "not @disabled",
        plugin = {
                "lv.ss.at.allure.AllureScreenshotPublisher",
                "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm",
                "json:build/reports/cucumber-report/cucumber.json",
                "pretty"
        },
        strict = true
)
public class CukesRunner {
}
