package lv.ss.at;

import com.google.inject.AbstractModule;
import lv.ss.at.selenium.DriverProvider;
import org.openqa.selenium.WebDriver;

public class GuiceModule extends AbstractModule {
    @Override
    public void configure() {
        bind(WebDriver.class).toProvider(DriverProvider.class);
    }
}
