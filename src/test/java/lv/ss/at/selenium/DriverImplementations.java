package lv.ss.at.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum DriverImplementations {
    CHROME {
        @Override
        public void setUpDriver() {
            ChromeDriverManager.getInstance().setup();
        }

        @Override
        public RemoteWebDriver getWebDriver() {
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public void setUpDriver() {
            FirefoxDriverManager.getInstance().setup();
        }

        @Override
        public RemoteWebDriver getWebDriver() {
            return new FirefoxDriver();
        }
    };

    public abstract void setUpDriver();

    public abstract RemoteWebDriver getWebDriver();
}