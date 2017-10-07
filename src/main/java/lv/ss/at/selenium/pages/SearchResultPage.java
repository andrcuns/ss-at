package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.BaseFunctions;
import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public void sortByPrice() {
        baseFunctions.click(SORT_BY_PRICE);
    }

    public void selectDealType(String dealType) {
        baseFunctions.selectValueInDropDownField(DEAL_TYPE, dealType);
    }

    public void openAdvancedSearchPage() {
        baseFunctions.click(ADVANCED_SEARCH);
    }

    public void showSelectedItems() {
        baseFunctions.click(SHOW_SELECTED_LINK);
    }

    public List<AdvertisementItemWrapper> getRandomAdvertisementItems(int count) {
        List<WebElement> elements = baseFunctions.findElements(ADVERTISEMENT_ITEMS);
        Collections.shuffle(elements);

        return elements.stream()
                .limit(count)
                .map(AdvertisementItemWrapper::new)
                .sorted()
                .collect(Collectors.toList());
    }

    public void selectAdvertisementItems(List<AdvertisementItemWrapper> list) {
        list.forEach(AdvertisementItemWrapper::selectItem);
    }
}
