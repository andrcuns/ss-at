package lv.ss.at.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends CommonInAllPages {

    private static final String URL = "http://ss.com";

    public void expectWebElements() {
        expectCommonWebElements();
    }

    @Step("Open home page")
    public void openPage() {
        open(URL);
    }

    @Step("Change language")
    public void changeLanguage() {
        languageSelector.click();
    }

    @Step("Open link by text: {text}")
    public void clickLinkWithText(String text) {
        $(By.linkText(text)).click();
    }

}
