package lv.ss.at.configuration;

import com.google.inject.AbstractModule;
import org.slf4j.bridge.SLF4JBridgeHandler;

import static lv.ss.at.configuration.DriverSetupImplementation.setUpWebBrowser;

public class GuiceModule extends AbstractModule {

    @Override
    public void configure() {
        routeJulToSlf();
        setUpWebBrowser();
    }

    private void routeJulToSlf() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
}
