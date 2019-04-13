package lv.ss.at.cukes.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.getLifecycle;

public class Hooks {

    @Before("@blank")
    public void beforeBlank() {}

    @After("@blank")
    public void afterBlank() {}

    @After("not @blank")
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            getLifecycle().addAttachment("Failure Image", "image/png", "png", screenShot);
        }
        clearBrowserCache();
        getLifecycle().updateFixture(fixtureResult -> fixtureResult.setName("Clean up"));
    }
}
