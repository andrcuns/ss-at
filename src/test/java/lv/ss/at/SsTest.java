package lv.ss.at;

import lv.ss.at.selenium.BaseFunctions;
import lv.ss.at.selenium.pages.HomePage;
import lv.ss.at.selenium.pages.SearchPage;
import lv.ss.at.selenium.pages.SearchResultPage;
import lv.ss.at.selenium.pages.ShowSelectedPage;
import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
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

    @Before
    public void setUp() {
        baseFunctions.initDriver();
    }

    @Rule
    public TestWatcher closeBrowser = new TestWatcher() {
        @Override
        protected void finished(Description description) {
            baseFunctions.quit();
        }
    };

    @Test
    @Ignore
    public void SsScenario() {
        final long MIN_PRICE = 0;
        final long MAX_PRICE = 300;
        final int ITEMS_TO_SELECT = 4;
        List<AdvertisementItemWrapper> selectedItems;
        List<AdvertisementItemWrapper> showedSelectedItems;

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
        searchPage.fillPriceValues(MIN_PRICE, MAX_PRICE);
        searchPage.selectPeriod("За последний месяц");
        searchPage.submitSearchForm();

        searchResultPage.expectWebElements();
        selectedItems = searchResultPage.getRandomAdvertisementItems(ITEMS_TO_SELECT);
        searchResultPage.selectAdvertisementItems(selectedItems);
        searchResultPage.showSelectedItems();

        showSelectedPage.expectWebElements();
        showedSelectedItems = showSelectedPage.getAllAdvertisementItems();

        assertThat("Selected items do not match", selectedItems, is(showedSelectedItems));
    }

}
