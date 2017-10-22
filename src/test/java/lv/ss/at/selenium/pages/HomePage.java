package lv.ss.at.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends CommonInAllPages {

    private static final String URL = "ss.com";

    public void expectWebElements() {
        expectCommonWebElements();
    }

    @Step("Open home page")
    public void open() {
        baseFunctions.goToUrl(URL);
    }

    @Step("Change language")
    public void changeLanguage() {
        baseFunctions.click(LANGUAGE_SELECTOR);
    }

    @Step("Open link by text: {text}")
    public void clickLinkWithText(String text) {
        baseFunctions.click(By.linkText(text));
    }

}
