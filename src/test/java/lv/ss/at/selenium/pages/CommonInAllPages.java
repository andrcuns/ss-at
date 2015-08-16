package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.BaseFunctions;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CommonInAllPages {

    public static final By LANGUAGE_SELECTOR = By.xpath("//*[@class='menu_lang']/a");
    public static final By SEARCH = By.xpath(".//*[@id='main_table']//*[contains(@href, '/search/')]");
    
    @Autowired
    BaseFunctions baseFunctions;
    
    public void expectCommonWebElements() {
        baseFunctions.waitUntil(visibilityOfElementLocated(LANGUAGE_SELECTOR));
        baseFunctions.waitUntil(visibilityOfElementLocated(SEARCH));
    }
    
    public void openSearchPage() {
        baseFunctions.click(SEARCH);
    }
}
