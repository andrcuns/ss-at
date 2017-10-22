package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class ShowSelectedPage extends CommonInAllPages {

    private static final By ADVERTISEMENT_ITEMS = By.xpath("//*[starts-with(@id, 'tr_') and not(contains(@id, 'bnr'))]");

    public void expectWebElements() {
        expectCommonWebElements();
    }

    public List<AdvertisementItemWrapper> getAllAdvertisementItems() {
        return baseFunctions.findElements(ADVERTISEMENT_ITEMS).stream()
                .map(AdvertisementItemWrapper::new)
                .sorted()
                .collect(Collectors.toList());
    }
}
