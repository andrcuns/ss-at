package lv.ss.at.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
public class BaseFunctions {

    private WebDriver driver;

    public BaseFunctions() {
    }

    public void startDriver() {
        switch (System.getProperty("webdriver", "chrome")) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                this.driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                FirefoxDriverManager.getInstance().setup();
                this.driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
    }

    public void stopDriver() {
        driver.close();
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
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

    public void type(By by, Keys key) {
        waitUntil(visibilityOfElementLocated(by));
        WebElement webElement = findElement(by);
        webElement.sendKeys(key);
    }

    public void selectValueInDropDownField(By by, String value) {
        waitUntil(visibilityOfElementLocated(by));
        Select select = new Select(findElement(by));
        select.selectByVisibleText(value);
    }

    public List<WebElement> findElements(By by) {
        waitUntil(presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }
}
