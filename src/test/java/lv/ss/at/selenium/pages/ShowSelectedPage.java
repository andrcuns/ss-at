package lv.ss.at.selenium.pages;

import lv.ss.at.selenium.BaseFunctions;
import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShowSelectedPage extends CommonInAllPages {

    private static final By ADVERTISEMENT_ITEMS = By.xpath("//*[starts-with(@id, 'tr_') and not(contains(@id, 'bnr'))]");

    @Autowired
    BaseFunctions baseFunctions;

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
