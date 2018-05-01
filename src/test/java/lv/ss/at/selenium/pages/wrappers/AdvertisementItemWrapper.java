package lv.ss.at.selenium.pages.wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static java.lang.Long.parseLong;

public class AdvertisementItemWrapper implements Comparable {

    private SelenideElement selenideElement;
    private String elementId;
    private By checkbox = By.xpath(".//*[@type='checkbox']");
    private By price = By.cssSelector("td:nth-of-type(7) .amopt");

    public AdvertisementItemWrapper(SelenideElement selenideElement) {
        this.selenideElement = selenideElement;
        this.elementId = selenideElement.getAttribute("id");
    }

    public void selectItem() {
        selenideElement.find(checkbox).click();
    }

    public long getItemPrice() {
        return parseLong(selenideElement.findElement(price).getText().replace(" €", ""));
    }


    @Override
    public int compareTo(Object o) {
        AdvertisementItemWrapper other = (AdvertisementItemWrapper) o;
        return elementId.compareTo(other.elementId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AdvertisementItemWrapper that = (AdvertisementItemWrapper) o;

        return elementId.equals(that.elementId);
    }

    @Override
    public int hashCode() {
        return elementId.hashCode();
    }
}
