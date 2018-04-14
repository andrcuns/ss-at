package lv.ss.at.selenium;

import com.codeborne.selenide.Configuration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static java.lang.System.getProperty;

public enum DriverSetupImplementation {
    CHROME {
        @Override
        void setBrowser() {
            chromedriver().setup();
            Configuration.browser = "chrome";
        }
    },
    FIREFOX {
        @Override
        void setBrowser() {
            firefoxdriver().setup();
            Configuration.browser = "firefox";
        }
    };

    abstract void setBrowser();

    public static void setUpWebBrowser() {
        valueOf(getProperty("browser", "chrome").toUpperCase()).setBrowser();
    }
}