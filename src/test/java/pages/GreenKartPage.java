package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GreenKartPage {

    WebDriver driver;

    public GreenKartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By searchBox = By.xpath("//input[@type='search']");
    By plusButton = By.xpath("//input[@type='number']/following-sibling::*");
    By addToCart = By.xpath("//div[@class='product-action']/child::*");
    By cartIcon = By.xpath("//a[@class='cart-icon']/child::img[@alt='Cart']");
    By productText = By.xpath("(//li//p[text()='Brocolli - 1 Kg'])[1]");
    By proceedToCheckout = By.xpath("//*[@type='button' and text()='PROCEED TO CHECKOUT']");
    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By countryDropdown = By.xpath("//select");
    By agreeCheckbox = By.xpath("//input[@type='checkbox']");
    By proceedBtn = By.xpath("//button");

    // Actions
    public void launchApp() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
    }

    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
    }

    public void increaseQuantity() {
        driver.findElement(plusButton).click();
        driver.findElement(plusButton).click();
    }

    public void addProductToCart() {
        driver.findElement(addToCart).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public String getProductText() {
        return driver.findElement(productText).getText();
    }

    public void proceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }

    public void placeOrder() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(placeOrderBtn).click();

        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByValue("India");

        driver.findElement(agreeCheckbox).click();
        driver.findElement(proceedBtn).click();
    }
}

