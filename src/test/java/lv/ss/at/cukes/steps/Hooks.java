package lv.ss.at.cukes.steps;

import cucumber.api.java.After;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static io.qameta.allure.Allure.getLifecycle;

public class Hooks {

    @After
    public void cleanUp() {
        clearBrowserCache();
        updateStepName("Clear browser cache");
    }

    private void updateStepName(String name) {
        getLifecycle().updateStep(stepResult -> stepResult.setName(name));
    }
}
