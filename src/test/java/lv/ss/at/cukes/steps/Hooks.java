package lv.ss.at.cukes.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import lv.ss.at.cukes.SpringTest;
import lv.ss.at.selenium.BaseFunctions;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks extends SpringTest {

    @Autowired
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
