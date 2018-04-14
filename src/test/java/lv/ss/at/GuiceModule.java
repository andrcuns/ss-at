package lv.ss.at;

import com.codeborne.selenide.Configuration;
import com.google.inject.AbstractModule;
import lv.ss.at.selenium.DriverSetupImplementation;

public class GuiceModule extends AbstractModule {

    @Override
    public void configure() {
        Configuration.startMaximized = false;
        Configuration.browserSize = "1920x1080";

        DriverSetupImplementation.setUpWebBrowser();
    }
}
