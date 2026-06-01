package stepdefinition;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlightBookingPageWithBasetest;

public class FlightBookingStepDefinition {
	
	WebDriver driver;
	
	FlightBookingPageWithBasetest flight ;
	

@Given("user login on flight websites")
public void user_login_on_flight_websites() {
    // Write code here that turns the phrase above into concrete actions
	 driver = DriverFactory.getDriver(); 
	 flight = new FlightBookingPageWithBasetest(driver);
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");
   // throw new io.cucumber.java.PendingException();
}

@When("user search the flights")
public void user_search_the_flights() {
    // Write code here that turns the phrase above into concrete actions
	flight.searchFlight();
   // throw new io.cucumber.java.PendingException();
}

@Then("Validation of resutls")
public void validation_of_resutls() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}

}
