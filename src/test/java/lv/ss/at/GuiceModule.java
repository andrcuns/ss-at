package lv.ss.at;

import com.google.inject.AbstractModule;
import lv.ss.at.selenium.DriverImplementations;
import lv.ss.at.selenium.DriverProvider;
import org.openqa.selenium.WebDriver;

import static java.lang.System.getProperty;

public class GuiceModule extends AbstractModule {

    @Override
    public void configure() {
        DriverImplementations
                .valueOf(getProperty("webdriver", "chrome").toUpperCase())
                .setUpDriver();
        bind(WebDriver.class).toProvider(DriverProvider.class);
    }
}
