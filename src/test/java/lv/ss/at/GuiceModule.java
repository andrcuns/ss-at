package lv.ss.at;

import com.google.inject.AbstractModule;
import lv.ss.at.selenium.DriverSetupImplementations;

import static java.lang.System.getProperty;

public class GuiceModule extends AbstractModule {

    @Override
    public void configure() {
        DriverSetupImplementations
                .valueOf(getProperty("browser", "chrome").toUpperCase())
                .setUpDriver();
    }
}
