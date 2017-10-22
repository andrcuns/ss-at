package lv.ss.at.cukes.steps;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;
import lv.ss.at.selenium.BaseFunctions;

@ScenarioScoped
public class Hooks {

    @Inject
    BaseFunctions baseFunctions;

    @Before
    public void setUp() {
        baseFunctions.initDriver();
    }

    @After
    public void tearDown() {
        baseFunctions.quit();
    }
}
