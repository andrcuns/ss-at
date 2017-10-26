package lv.ss.at.cukes.steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;
import lv.ss.at.selenium.pages.HomePage;

@ScenarioScoped
public class HomePageStepDefs {

    @Inject
    HomePage homePage;

    @Given("^client opens ss.lv home page$")
    public void openHomePage() {
        homePage.openPage();
    }

    @Then("^page is opened$")
    public void isHomePageOpened() {
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
