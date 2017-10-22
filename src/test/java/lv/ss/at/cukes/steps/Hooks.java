package lv.ss.at.cukes.steps;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.runtime.java.guice.ScenarioScoped;
import lv.ss.at.selenium.BaseFunctions;

@ScenarioScoped
public class Hooks {

    @Inject
    BaseFunctions baseFunctions;

    @After
    public void tearDown() {
        baseFunctions.quit();
    }
}
