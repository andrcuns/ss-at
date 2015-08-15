package lv.ss.at;

import lv.ss.at.selenium.BaseFunctions;
import lv.ss.at.selenium.pages.HomePage;
import lv.ss.at.selenium.pages.SearchPage;
import lv.ss.at.selenium.pages.SearchResultPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    BaseFunctions baseFunctions;
    
    @After
    public void tearDown() {
        baseFunctions.stopDriver();
    }
    
    @Test
    public void SsScenario() {
        homePage.open();
        homePage.expectWebElements();
        
        homePage.changeLanguage();
        
        homePage.clickLinkWithText("Электротехника");
        
        homePage.openSearchPage();
        searchPage.expectWebElements();
        searchPage.fillSearchForm("ноутбук", "Рига", "За последний месяц");
        searchPage.submitSearchForm();
        
        searchResultPage.expectWebElements();
        searchResultPage.sortByPrice();
        searchResultPage.selectDealType("Продажа");
        searchResultPage.openAdvancedSearchPage();
        
        searchPage.expectWebElements();
        searchPage.fillPriceValues(0, 300);
        searchPage.selectPeriod("За последний месяц");
        searchPage.submitSearchForm();
    }
}
