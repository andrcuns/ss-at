package lv.ss.at.allure;

import cucumber.api.Result;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestStepFinished;
import cucumber.api.formatter.Formatter;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllureScreenshotPublisher implements Formatter {
    private final Logger log = LoggerFactory.getLogger(AllureScreenshotPublisher.class);
    private final AllureLifecycle allureLifecycle;

    public AllureScreenshotPublisher() {
        this.allureLifecycle = Allure.getLifecycle();
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestStepFinished(final TestStepFinished event) {
        if (event.result.getStatus() == Result.Type.FAILED) {
            log.error("Step '{}' failed! Attaching screen shot...", event.testStep.getStepText());

            byte[] screenShot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            allureLifecycle.addAttachment("Failure Image", "image/png", "png", screenShot);
        }
    }
}
