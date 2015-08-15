package lv.ss.at.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
public class BaseFunctions {

    WebDriver driver;
    private static final String CHROME_DRIVER_LINUX = "chromedriver";
    private static final String CHROME_DRIVER_WINDOWS = "chromedriver.exe";

    public BaseFunctions() {

        String CHROME_DRIVER = getProperty("os.name").equalsIgnoreCase("windows") ?
                CHROME_DRIVER_WINDOWS : CHROME_DRIVER_LINUX;

        setProperty("webdriver.chrome.driver", CHROME_DRIVER);

        this.driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void stopDriver() {
        driver.close();
    }

    public void waitUntil(ExpectedCondition<?> until, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(until);
    }

    public void waitUntil(ExpectedCondition<?> until) {
        waitUntil(until, 30);
    }

    public void click(By by) {
        waitUntil(elementToBeClickable(by));
        findElement(by).click();
    }

    public WebElement findElement(By by) {
        waitUntil(presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public void type(By by, String text) {
        waitUntil(visibilityOfElementLocated(by));
        WebElement webElement = findElement(by);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void selectValueInDropDownField(By by, String value) {
        waitUntil(visibilityOfElementLocated(by));
        Select select = new Select(findElement(by));
        select.selectByVisibleText(value);
    }
}
