package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GreenKartPage1 {
	
	private WebDriver driver2;
	
    public GreenKartPage1(WebDriver driver2) {
		// TODO Auto-generated constructor stub
    	 this.driver2 = driver2;
	}

	

	// Locators
    private By searchBox = By.xpath("//input[@type='search']");
     private By plusButton = By.xpath("//input[@type='number']/following-sibling::*");
     private By addToCart = By.xpath("//div[@class='product-action']/child::*");
     private By cartIcon = By.xpath("//a[@class='cart-icon']/child::img[@alt='Cart']");
     private By productText = By.xpath("(//li//p[text()='Brocolli - 1 Kg'])[1]");
     private By proceedToCheckout = By.xpath("//*[@type='button' and text()='PROCEED TO CHECKOUT']");
     private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
     private  By countryDropdown = By.xpath("//select");
     private  By agreeCheckbox = By.xpath("//input[@type='checkbox']");
     private  By proceedBtn = By.xpath("//button");
	

	// Actions
     public void launchApp1() {
         driver2.get("https://rahulshettyacademy.com/seleniumPractise/#/");
         driver2.manage().window().maximize();
     }
     
     public void searchProduct1(String product) {
         driver2.findElement(searchBox).sendKeys(product);
     }
     
     public void increaseQuantity1() {
         driver2.findElement(plusButton).click();
         driver2.findElement(plusButton).click();
     }
     
     public void addProductToCart1() {
         driver2.findElement(addToCart).click();
     }

     public void openCart1() {
         driver2.findElement(cartIcon).click();
     }

     public String getProductText1() {
         return driver2.findElement(productText).getText();
     }

     public void proceedToCheckout1() {
         driver2.findElement(proceedToCheckout).click();
     }

     public void placeOrder1() {
         driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver2.findElement(placeOrderBtn).click();

         Select select = new Select(driver2.findElement(countryDropdown));
         select.selectByValue("India");

         driver2.findElement(agreeCheckbox).click();
         driver2.findElement(proceedBtn).click();
     }

}
