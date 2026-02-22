package stepdefinition;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import pages.GreenKartPage;

public class GreenKartSteps {

    WebDriver driver;
    GreenKartPage greenKartPage;
    SoftAssert softAssert = new SoftAssert();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        greenKartPage = new GreenKartPage(driver);
    }

    @Given("user launches the GreenKart application")
    public void user_launches_application() {
        greenKartPage.launchApp();
    }

    @When("user searches for {string}")
    public void user_searches_for_product(String product) {
        greenKartPage.searchProduct(product);
    }

    @When("user increases the quantity")
    public void user_increases_quantity() {
        greenKartPage.increaseQuantity();
    }

    @When("user adds the product to cart")
    public void user_adds_product_to_cart() {
        greenKartPage.addProductToCart();
        greenKartPage.openCart();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        softAssert.assertEquals(
                greenKartPage.getProductText(),
                "Brocolli - 1 Kg",
                "Product text mismatch"
        );
        greenKartPage.proceedToCheckout();
    }

    @When("user places the order")
    public void user_places_the_order() {
        greenKartPage.placeOrder();
    }

    @Then("order should be placed successfully")
    public void order_should_be_placed_successfully() {
        softAssert.assertAll();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

