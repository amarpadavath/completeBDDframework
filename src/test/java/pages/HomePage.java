package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.id("search");
    private By searchButton = By.id("searchBtn");
    private By results = By.id("results");

    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void verifyResults() {
        if(driver.findElement(results).isDisplayed()) {
            System.out.println("Search Results Displayed");
        }
    }
}