package lv.ss.at.selenium.pages.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdvertisementItemWrapper implements Comparable {

    private WebElement webElement;
    private String elementId;
    private static final By CHECKBOX = By.xpath(".//*[@type='checkbox']");

    public AdvertisementItemWrapper(WebElement webElement) {
        this.webElement = webElement;
        this.elementId = webElement.getAttribute("id");
    }

    public void selectItem() {
        webElement.findElement(CHECKBOX).click();
    }


    @Override
    public int compareTo(Object o) {
        AdvertisementItemWrapper other = (AdvertisementItemWrapper) o;
        return elementId.compareTo(other.elementId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementItemWrapper that = (AdvertisementItemWrapper) o;

        return elementId.equals(that.elementId);
    }

    @Override
    public int hashCode() {
        return elementId.hashCode();
    }
}
