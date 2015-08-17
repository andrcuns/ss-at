package lv.ss.at;

import lv.ss.at.selenium.BaseFunctions;
import lv.ss.at.selenium.pages.HomePage;
import lv.ss.at.selenium.pages.SearchPage;
import lv.ss.at.selenium.pages.SearchResultPage;
import lv.ss.at.selenium.pages.ShowSelectedPage;
import lv.ss.at.selenium.pages.objects.AdvertisementItemWrapper;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class SsTest {

    @Autowired
    HomePage homePage;

    @Autowired
    SearchPage searchPage;

    @Autowired
    SearchResultPage searchResultPage;

    @Autowired
    ShowSelectedPage showSelectedPage;

    @Autowired
    BaseFunctions baseFunctions;

    @After
    public void tearDown() {
        baseFunctions.stopDriver();
    }

    @Test
    public void SsScenario() {
        List<AdvertisementItemWrapper> selected;
        List<AdvertisementItemWrapper> selectedShowed;

        homePage.open();
        homePage.expectWebElements();

        homePage.changeLanguage();

        homePage.clickLinkWithText("Электротехника");
        homePage.openSearchPage();

        searchPage.expectWebElements();
        searchPage.fillAndSubmitSearchForm("ноутбук", "Рига", "За последний месяц");

        searchResultPage.expectWebElements();
        searchResultPage.sortByPrice();
        searchResultPage.selectDealType("Продажа");
        searchResultPage.openAdvancedSearchPage();

        searchPage.expectWebElements();
        searchPage.fillPriceValues(0, 300);
        searchPage.selectPeriod("За последний месяц");
        searchPage.submitSearchForm();

        searchResultPage.expectWebElements();
        selected = searchResultPage.getRandomAdvertisementItems(4);
        searchResultPage.selectAdvertisementItems(selected);
        searchResultPage.showSelectedItems();

        showSelectedPage.expectWebElements();
        selectedShowed = showSelectedPage.getAllAdvertisementItems();

        assertThat("Selected items do not match", selected, is(selectedShowed));
    }

}
