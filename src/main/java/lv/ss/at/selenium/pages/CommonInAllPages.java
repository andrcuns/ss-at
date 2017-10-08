package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.BaseFunctions;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class CommonInAllPages {

    static final By LANGUAGE_SELECTOR = By.xpath("//*[@class='menu_lang']/a");
    static final By SEARCH = By.xpath(".//*[@id='main_table']//*[contains(@href, '/search/')]");

    final BaseFunctions baseFunctions;

    public CommonInAllPages(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    void expectCommonWebElements() {
        baseFunctions.waitUntil(visibilityOfElementLocated(LANGUAGE_SELECTOR));
        baseFunctions.waitUntil(visibilityOfElementLocated(SEARCH));
    }

    public void openSearchPage() {
        baseFunctions.click(SEARCH);
    }
}
