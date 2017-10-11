package lv.ss.at.cukes.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lv.ss.at.cukes.SpringTest;
import lv.ss.at.selenium.pages.HomePage;
import lv.ss.at.selenium.pages.SearchPage;
import lv.ss.at.selenium.pages.SearchResultPage;
import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchPageStepDefs extends SpringTest {

    @Autowired
    HomePage homePage;
    @Autowired
    SearchPage searchPage;
    @Autowired
    SearchResultPage searchResultPage;

    List<AdvertisementItemWrapper> selectedItems;
    List<AdvertisementItemWrapper> shownItems;

    @And("he opens search page$")
    public void openSearchPage() {
        homePage.openSearchPage();
        searchPage.expectWebElements();
    }

    @When("client fills in input: (.+), region: (.+) and period: (.+)$")
    public void fillSearchAndSubmit(String input, String region, String period) {
        searchPage.fillAndSubmitSearchForm(input, region, period);
    }

    @Then("^search result page is opened$")
    public void isSearchResultOpened() {
        searchResultPage.expectWebElements();
    }

    @When("^client selects (\\d+) random elements$")
    public void client_selects_random_elements(int number) {
        selectedItems = searchResultPage.getRandomAdvertisementItems(number);
        searchResultPage.selectAdvertisementItems(selectedItems);
    }

    @When("^he clicks on show selected items link$")
    public void he_clicks_on_show_selected_items_link() {
        searchResultPage.showSelectedItems();
    }

    @Then("^only (\\d+) selected elements are shown$")
    public void only_selected_elements_are_shown(int number) {
        shownItems = searchResultPage.getRandomAdvertisementItems(number);
        assertThat("Shown items do not match previously selected items", selectedItems, is(shownItems));
    }
}