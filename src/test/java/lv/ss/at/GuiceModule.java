package lv.ss.at;

import com.google.inject.AbstractModule;
import lv.ss.at.selenium.DriverSetupImplementations;

public class GuiceModule extends AbstractModule {

    @Override
    public void configure() {
        DriverSetupImplementations.setUpCorrectDriver();
    }
}
