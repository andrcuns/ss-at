package lv.ss.at.selenium.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;

public class SearchResultPage extends CommonInAllPages {

    private SelenideElement sortByPrice = $(By.cssSelector(".a18"));
    private SelenideElement dealType = $(By.xpath("//*[@class='filter_sel']"));
    private SelenideElement advancedSearch = $(By.xpath("//*[@class='td7']//*[@class='a9a']"));
    private SelenideElement showSelectedLink = $(By.cssSelector("#show_selected_a"));
    private ElementsCollection advertisementItems = $$(By.xpath("//*[starts-with(@id, 'tr_') and not(contains(@id, 'bnr'))]"));

    public void expectWebElements() {
        expectCommonWebElements();
        sortByPrice.isDisplayed();
        dealType.isDisplayed();
        advancedSearch.isDisplayed();
    }

    @Step("Show selected items")
    public void showSelectedItems() {
        showSelectedLink.click();
    }

    @Step("Select items")
    public void selectAdvertisementItems(List<AdvertisementItemWrapper> list) {
        list.forEach(AdvertisementItemWrapper::selectItem);
    }

    public List<AdvertisementItemWrapper> getRandomAdvertisementItems(int count) {
        List<AdvertisementItemWrapper> list = getAdvertisementItems();
        Collections.shuffle(list);

        return list.stream()
                .limit(count)
                .sorted()
                .collect(toList());
    }

    public List<AdvertisementItemWrapper> getAdvertisementItems() {
        return advertisementItems.stream()
                .map(AdvertisementItemWrapper::new)
                .collect(toList());
    }
}
