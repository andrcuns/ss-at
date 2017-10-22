package lv.ss.at.selenium;

import com.google.inject.Provider;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

import static java.lang.System.getProperty;
import static lv.ss.at.selenium.DriverProvider.DriverImplementations.getDriverImplementation;

public class DriverProvider implements Provider<WebDriver> {

    @Override
    public WebDriver get() {
        return getDriverImplementation(getProperty("webdriver", "chrome")).getDriver();
    }

    enum DriverImplementations {
        CHROME("chrome") {
            @Override
            WebDriver getDriver() {
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
            }
        },
        FIREFOX("firefox") {
            @Override
            WebDriver getDriver() {
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            }
        };

        String browser;

        DriverImplementations(String browser) {
            this.browser = browser;
        }

        abstract WebDriver getDriver();

        static DriverImplementations getDriverImplementation(String browser) {
            return Arrays.stream(values())
                    .filter(driverImplementation -> driverImplementation.browser.equals(browser))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("WebDriver not found!"));
        }
    }
}
