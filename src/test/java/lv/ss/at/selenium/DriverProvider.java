package lv.ss.at.selenium;

import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;

import static java.lang.System.getProperty;

public class DriverProvider implements Provider<WebDriver> {

    @Override
    public WebDriver get() {
        return DriverImplementations
                .valueOf(getProperty("webdriver", "chrome").toUpperCase())
                .getWebDriver();
    }
}
