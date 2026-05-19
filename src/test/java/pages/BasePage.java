package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Click element
    public void click(By locator)
    {
        wait.until(
                ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    // Enter text
    public void enterText(By locator,String value)
    {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(value);
    }

    // Get text
    public String getText(By locator)
    {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }

    // Is displayed
    public boolean isDisplayed(By locator)
    {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator))
                .isDisplayed();
    }

    // Wait for visibility
    public WebElement waitForElement(By locator)
    {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Clear field
    public void clear(By locator)
    {
        waitForElement(locator).clear();
    }

    // Page title
    public String getTitle()
    {
        return driver.getTitle();
    }

    // Current URL
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }

    // Navigate
    public void navigate(String url)
    {
        driver.get(url);
    }
}