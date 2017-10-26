package lv.ss.at.selenium.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class CommonInAllPages {

    private SelenideElement search = $(By.xpath(".//*[@id='main_table']//*[contains(@href, '/search/')]"));
    SelenideElement languageSelector = $(By.xpath("//*[@class='menu_lang']/a"));

    void expectCommonWebElements() {
        languageSelector.isDisplayed();
        search.isDisplayed();
    }

    public void openSearchPage() {
        search.click();
    }
}
