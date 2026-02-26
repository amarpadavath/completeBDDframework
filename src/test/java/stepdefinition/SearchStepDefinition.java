package stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import pages.HomePage;

import java.util.List;

public class SearchStepDefinition {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("User is on the Home page")
    public void user_is_on_home_page() {
        driver.get("https://example.com");
    }

    @When("User searches for below products")
    public void user_searches_for_products(DataTable dataTable) {

        List<String> productList = dataTable.asList(String.class);

        for (String product : productList) {
            homePage.searchProduct(product);
        }
    }

    @Then("Search results should be displayed")
    public void verify_search_results() {
        homePage.verifyResults();
    }
}