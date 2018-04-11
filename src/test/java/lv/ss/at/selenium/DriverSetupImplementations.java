package lv.ss.at.selenium;

import com.codeborne.selenide.Configuration;

import static java.lang.System.getProperty;

public enum DriverSetupImplementations {
    CHROME {
        @Override
        void setBrowser() {
            Configuration.browser = "chrome";
        }
    },
    FIREFOX {
        @Override
        void setBrowser() {
            Configuration.browser = "firefox";
        }
    };

    abstract void setBrowser();

    public static void setUpWebBrowser() {
        valueOf(getProperty("browser", "chrome").toUpperCase()).setBrowser();
    }
}