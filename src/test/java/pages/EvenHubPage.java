package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EvenHubPage {

    WebDriver driver;

    public EvenHubPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registerBtn = By.xpath("//a[@href='/register']");
    private By emailField = By.xpath("//input[@placeholder='you@email.com']");
    private By passwordField = By.xpath("//input[@placeholder='Min 8 chars, uppercase, number & symbol']");
    private By confirmPasswordField = By.xpath("//input[@placeholder='Repeat your password']");
    private By createAccountBtn = By.xpath("//button[text()='Create Account']");

    public void launchApp() {
        driver.get("https://eventhub.rahulshettyacademy.com/login");
        driver.manage().window().maximize();
    }

    public void clickOnReg() {
        driver.findElement(registerBtn).click();
    }

    public void sendEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void sendPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickOnCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }
}