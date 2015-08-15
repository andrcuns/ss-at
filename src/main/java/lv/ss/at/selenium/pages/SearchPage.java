package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.BaseFunctions;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Component
public class SearchPage extends CommonInAllPages{
    
    private static final By SEARCH_INPUT = By.cssSelector("#ptxt");
    private static final By MIN_PRICE_INPUT = By.xpath("//*[contains(@name, '[min]')]");
    private static final By MAX_PRICE_INPUT = By.xpath("//*[contains(@name, '[max]')]");
    private static final By REGION_SELECT = By.cssSelector("#s_region_select");
    private static final By PERIOD_SELECT = By.name("pr");
    private static final By SEARCH_BUTTON = By.cssSelector("#sbtn");
    private static final By SEARCH_INPUT_NAME = By.xpath("//*[@id='maindv2']/tbody/tr/td/form/table/tbody/tr[2]/td[1]");
    private static final By PRELOAD_TEXT = By.xpath("//*[@id='preload_txt']");
    
    @Autowired
    BaseFunctions baseFunctions;
    
    public void expectWebElements() {
        expectCommonWebElements();
        baseFunctions.waitUntil(visibilityOfElementLocated(SEARCH_INPUT));
        baseFunctions.waitUntil(visibilityOfElementLocated(MIN_PRICE_INPUT));
        baseFunctions.waitUntil(visibilityOfElementLocated(MAX_PRICE_INPUT));
        baseFunctions.waitUntil(visibilityOfElementLocated(REGION_SELECT));
        baseFunctions.waitUntil(visibilityOfElementLocated(PERIOD_SELECT));
        baseFunctions.waitUntil(visibilityOfElementLocated(SEARCH_BUTTON));
    }
    
    public void fillSearchForm(String searchInput, String region, String period) {
        baseFunctions.type(SEARCH_INPUT, searchInput);
        baseFunctions.click(SEARCH_INPUT_NAME);
        baseFunctions.selectValueInDropDownField(REGION_SELECT, region);
        selectPeriod(period);
    }
    
    public void selectPeriod(String period) {
        baseFunctions.selectValueInDropDownField(PERIOD_SELECT, period);
    }
    
    public void submitSearchForm() {
        baseFunctions.click(SEARCH_BUTTON);
    }
    
    public void fillPriceValues(long minValue, long maxValue) {
        baseFunctions.type(MIN_PRICE_INPUT, String.valueOf(minValue));
        baseFunctions.type(MAX_PRICE_INPUT, String.valueOf(maxValue));
    }
}
