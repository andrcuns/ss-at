package lv.ss.at.selenium.pages;

import io.qameta.allure.Step;
import lv.ss.at.selenium.BaseFunctions;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends CommonInAllPages {

    private static final String URL = "ss.com";

    @Autowired
    public HomePage(BaseFunctions baseFunctions) {
        super(baseFunctions);
    }

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
