package lv.ss.at.configuration;

import com.codeborne.selenide.Configuration;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static java.lang.System.getProperty;

public enum DriverSetupImplementation {
    CHROME {
        @Override
        void setBrowser() {
            chromedriver().version("73.0.3683.68").setup();
            CONFIGURE_BROWSER.accept("chrome");
        }
    },
    FIREFOX {
        @Override
        void setBrowser() {
            firefoxdriver().setup();
            CONFIGURE_BROWSER.accept("firefox");
        }
    };

    private static final Consumer<String> CONFIGURE_BROWSER = (browser) -> {
        Configuration.startMaximized = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = browser;
    };

    abstract void setBrowser();

    public static void setUpWebBrowser() {
        DriverSetupImplementation browser = Stream.of(values())
                .filter(it -> it.name().equalsIgnoreCase(getProperty("browser", "chrome")))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Please provide either 'chrome' or 'firefox'!"));
        browser.setBrowser();
    }
}