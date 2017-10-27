package lv.ss.at.selenium;

import com.codeborne.selenide.Configuration;

import static java.lang.System.getProperty;

public enum DriverSetupImplementations {
    CHROME {
        @Override
        void setUpDriver() {
            Configuration.browser = "chrome";
        }
    },
    FIREFOX {
        @Override
        void setUpDriver() {
            Configuration.browser = "marionette";
        }
    };

    abstract void setUpDriver();

    public static void setUpCorrectDriver() {
        valueOf(getProperty("browser", "chrome").toUpperCase()).setUpDriver();
    }
}