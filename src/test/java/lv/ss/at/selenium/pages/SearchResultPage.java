package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.BaseFunctions;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Component
public class SearchResultPage extends CommonInAllPages {
    
    private static final By SORT_BY_PRICE = By.cssSelector(".a18");
    private static final By DEAL_TYPE = By.xpath("(.//*[@class='filter_sel'])[4]");
    private static final By ADVANCED_SEARCH = By.xpath(".//*[@class='td7']//*[@class='a9a']");
    
    @Autowired
    BaseFunctions baseFunctions;
    
    public void expectWebElements() {
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
}
