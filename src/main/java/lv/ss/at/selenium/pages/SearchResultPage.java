package lv.ss.at.selenium.pages;

import io.qameta.allure.Step;
import lv.ss.at.selenium.BaseFunctions;
import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Component
public class SearchResultPage extends CommonInAllPages {

    private static final By SORT_BY_PRICE = By.cssSelector(".a18");
    private static final By DEAL_TYPE = By.xpath("//*[@class='filter_sel']");
    private static final By ADVANCED_SEARCH = By.xpath("//*[@class='td7']//*[@class='a9a']");
    private static final By ADVERTISEMENT_ITEMS = By.xpath("//*[starts-with(@id, 'tr_') and not(contains(@id, 'bnr'))]");
    private static final By SHOW_SELECTED_LINK = By.cssSelector("#show_selected_a");

    @Autowired
    public SearchResultPage(BaseFunctions baseFunctions) {
        super(baseFunctions);
    }

    public void expectWebElements() {
        expectCommonWebElements();
        baseFunctions.waitUntil(visibilityOfElementLocated(SORT_BY_PRICE));
        baseFunctions.waitUntil(visibilityOfElementLocated(DEAL_TYPE));
        baseFunctions.waitUntil(visibilityOfElementLocated(ADVANCED_SEARCH));
    }

    @Step("Sort by price")
    public void sortByPrice() {
        baseFunctions.click(SORT_BY_PRICE);
    }

    @Step("Select deal type: {dealType}")
    public void selectDealType(String dealType) {
        baseFunctions.selectValueInDropDownField(DEAL_TYPE, dealType);
    }

    @Step("Open advanced search page")
    public void openAdvancedSearchPage() {
        baseFunctions.click(ADVANCED_SEARCH);
    }

    @Step("Show selected items")
    public void showSelectedItems() {
        baseFunctions.click(SHOW_SELECTED_LINK);
    }

    public List<AdvertisementItemWrapper> getAdvertisementItems() {
        return baseFunctions.findElements(ADVERTISEMENT_ITEMS).stream()
                .map(AdvertisementItemWrapper::new)
                .collect(toList());
    }

    public List<AdvertisementItemWrapper> getRandomAdvertisementItems(int count) {
        List<AdvertisementItemWrapper> list = getAdvertisementItems();
        Collections.shuffle(list);

        return list.stream()
                .limit(count)
                .sorted()
                .collect(toList());
    }

    @Step("Select items")
    public void selectAdvertisementItems(List<AdvertisementItemWrapper> list) {
        list.forEach(AdvertisementItemWrapper::selectItem);
    }
}
