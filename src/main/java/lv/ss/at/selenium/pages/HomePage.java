package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.BaseFunctions;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends CommonInAllPages {

    private static final String URL = "ss.lv";

    @Autowired
    BaseFunctions baseFunctions;

    public void expectWebElements() {
        expectCommonWebElements();
        
    }
    
    public void open() {
        baseFunctions.goToUrl(URL);
    }

    public void changeLanguage() {
        baseFunctions.click(LANGUAGE_SELECTOR);
    }

    public void clickLinkWithText(String text) {
        baseFunctions.click(By.linkText(text));
    }

}
