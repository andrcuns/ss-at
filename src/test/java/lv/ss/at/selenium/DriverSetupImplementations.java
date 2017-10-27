package lv.ss.at.selenium;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import static java.lang.System.getProperty;

public enum DriverSetupImplementations {
    CHROME {
        @Override
        void setUpDriver() {
            ChromeDriverManager.getInstance().setup();
            Configuration.browser = "chrome";
        }
    },
    FIREFOX {
        @Override
        void setUpDriver() {
            FirefoxDriverManager.getInstance().setup();
            Configuration.browser = "firefox";
        }
    };

    abstract void setUpDriver();

    public static void setUpCorrectDriver() {
        valueOf(getProperty("browser", "chrome").toUpperCase()).setUpDriver();
    }
}