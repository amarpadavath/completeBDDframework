package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GreenKartPage;
import pages.GreenKartPage1;

public class GreenKartSteps1 {
	
	//  WebDriver driver;
	//    GreenKartPage greenKartPage;
	 //   SoftAssert softAssert = new SoftAssert();
	
	WebDriver driver;
	GreenKartPage1 greenKartPage1;
	
	SoftAssert softAssert = new SoftAssert();
	
	@Before
    public void setUp() {
      driver = new ChromeDriver();
      greenKartPage1 = new GreenKartPage1(driver);
    }
	
	
	@Given("user launches the GreenKart")
	public void user_launches_the_green_kart() {
	    // Write code here that turns the phrase above into concrete actions
		   greenKartPage1.launchApp1();
	    throw new io.cucumber.java.PendingException();
	}
	@When("user searches test for {string}")
	public void user_searches_test_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
		  greenKartPage1.searchProduct1(string);
	    throw new io.cucumber.java.PendingException();
	}
	@When("user increases the quant")
	public void user_increases_the_quant() {
	    // Write code here that turns the phrase above into concrete actions
		 greenKartPage1.increaseQuantity1();
		
	    throw new io.cucumber.java.PendingException();
	}
	@When("user adds the product to")
	public void user_adds_the_product_to() {
	    // Write code here that turns the phrase above into concrete actions
		  greenKartPage1.addProductToCart1();
	        greenKartPage1.openCart1();
	    throw new io.cucumber.java.PendingException();
	}
	@When("user proceeds to")
	public void user_proceeds_to() {
	    // Write code here that turns the phrase above into concrete actions
		
		softAssert.assertEquals(
                greenKartPage1.getProductText1(),
                "Brocolli - 1 Kg",
                "Product text mismatch"
        );
        greenKartPage1.proceedToCheckout1();
	    throw new io.cucumber.java.PendingException();
	}
	@When("user places the")
	public void user_places_the() {
	    // Write code here that turns the phrase above into concrete actions
		  greenKartPage1.placeOrder1();
	    throw new io.cucumber.java.PendingException();
	}
	@Then("order should be placed")
	public void order_should_be_placed() {
	    // Write code here that turns the phrase above into concrete actions
		 softAssert.assertAll();
	    throw new io.cucumber.java.PendingException();
	}
	
	  @After
	    public void tearDown() {
	        driver.quit();
	    }

}
