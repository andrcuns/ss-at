package lv.ss.at.selenium.pages;

import com.codeborne.selenide.ElementsCollection;
import lv.ss.at.selenium.pages.wrappers.AdvertisementItemWrapper;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class ShowSelectedPage extends CommonInAllPages {

    private ElementsCollection advertisementItems = $$(By.xpath("//*[starts-with(@id, 'tr_') and not(contains(@id, 'bnr'))]"));

    public List<AdvertisementItemWrapper> getAllAdvertisementItems() {
        return advertisementItems.stream()
                .map(AdvertisementItemWrapper::new)
                .sorted()
                .collect(Collectors.toList());
    }
}
