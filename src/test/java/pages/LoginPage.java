package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exceptions.ElementNotFoundException;
import factory.DriverFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By successMsg = By.id("flash");

    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        return driver.findElement(successMsg)
                     .getText()
                     .contains("You logged into a secure area");
    }
    
    public void clickLogin() {
        try {
            driver.findElement(By.id("loginBtn")).click();
        } catch (Exception e) {
            throw new ElementNotFoundException("Login button not found on Login Page");
        }
    }

}
