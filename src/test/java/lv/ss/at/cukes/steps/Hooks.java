package lv.ss.at.cukes.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {

    @After
    public void cleanUp(Scenario scenario) {
        clearBrowserCache();
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            //noinspection ResultOfMethodCallIgnored
            attachAllureScreenshot(screenshot);
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] attachAllureScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
