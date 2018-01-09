package lv.ss.at.cukes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/lv/ss/at/cukes/features",
        glue = "classpath:lv/ss/at/cukes/steps",
        plugin = {"pretty", "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"}
)
public class CukesRunner {
}
