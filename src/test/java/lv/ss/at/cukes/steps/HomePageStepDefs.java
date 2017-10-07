package lv.ss.at.cukes.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import lv.ss.at.cukes.SpringTest;
import lv.ss.at.selenium.BaseFunctions;
import lv.ss.at.selenium.pages.HomePage;
import lv.ss.at.selenium.pages.SearchPage;
import lv.ss.at.selenium.pages.SearchResultPage;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageStepDefs extends SpringTest {

    @Autowired
    BaseFunctions baseFunctions;
    @Autowired
    HomePage homePage;
    @Autowired
    SearchPage searchPage;
    @Autowired
    SearchResultPage searchResultPage;

    @Given("^client opens ss.lv home page$")
    public void openHomePage() {
        homePage.open();
        homePage.expectWebElements();
    }

    @And("^he changes input language$")
    public void changeLanguage() {
        homePage.changeLanguage();
    }

    @And("he clicks link with text (.*)$")
    public void clickLinkWithText(String linkText) {
        homePage.clickLinkWithText(linkText);
    }

    @Given("^client has opened \"(.+)\" section$")
    public void client_has_opened_section(String linkText) {
        openHomePage();
        clickLinkWithText(linkText);
    }
}
