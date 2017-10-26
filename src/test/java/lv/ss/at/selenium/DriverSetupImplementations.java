package lv.ss.at.selenium;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public enum DriverSetupImplementations {
    CHROME {
        @Override
        public void setUpDriver() {
            ChromeDriverManager.getInstance().setup();
            Configuration.browser = "chrome";
        }
    },
    FIREFOX {
        @Override
        public void setUpDriver() {
            FirefoxDriverManager.getInstance().setup();
            Configuration.browser = "firefox";
        }
    };

    public abstract void setUpDriver();
}