package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightBookingPageWithBasetest extends BasePage{
	
	//BasePage s = new BasePage(driver);

	public FlightBookingPageWithBasetest(WebDriver driver) {
		super(driver);
		
	}
	
	private By departureCity = By.xpath("//input[@value='Departure City' and @id='ctl00_mainContent_ddl_originStation1_CTXT']");

	By arrivalCity = By.xpath("//input[ @id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
	
	public void searchFlight()
	{
		enterText( departureCity,"Kochi");
		enterText( arrivalCity,"Kochi");
	}
	
	public void seachtext()
	{
		enterText(departureCity, departureCity, "test", "test2");
	}
	
	// Locate the username field which is above the password field
	//WebElement usernameField = driver.findElement(
	//    with(By.tagName("input")).above(departureCity)
	//);
	
	//WebElement s = driver.findElement(With(By.xpath(getCurrentUrl()).above()))

	
}
