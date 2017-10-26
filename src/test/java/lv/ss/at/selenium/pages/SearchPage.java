package lv.ss.at.selenium.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends CommonInAllPages {

    private SelenideElement searchInput = $(By.cssSelector("#ptxt"));
    private SelenideElement minPriceInput = $(By.xpath("//*[contains(@name, '[min]')]"));
    private SelenideElement maxPriceInput = $(By.xpath("//*[contains(@name, '[max]')]"));
    private SelenideElement regionSelect = $(By.cssSelector("#s_region_select"));
    private SelenideElement periodSelect = $(By.name("pr"));
    private SelenideElement searchButton = $(By.cssSelector("#sbtn"));

    public void expectWebElements() {
        expectCommonWebElements();
        searchInput.isDisplayed();
        minPriceInput.isDisplayed();
        maxPriceInput.isDisplayed();
        regionSelect.isDisplayed();
        periodSelect.isDisplayed();
        searchButton.isDisplayed();
    }

    @Step("Fill search form with input: {searchInputString}, region: {region}, period: {period}")
    public void fillAndSubmitSearchForm(String searchInputString, String region, String period) {
        regionSelect.selectOption(region);
        periodSelect.selectOption(period);
        searchInput.append(searchInputString);
        searchInput.pressEnter();
    }

    public void fillPriceValuesAndSubmit(long minValue, long maxValue) {
        minPriceInput.append(String.valueOf(minValue));
        maxPriceInput.append(String.valueOf(maxValue));
        maxPriceInput.pressEnter();
    }
}
