package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingPage2PageFactory {
	
	//BasePage s = new BasePage(driver);
	  WebDriver driver;
	public FlightBookingPage2PageFactory(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	   @FindBy(xpath="//input[@value='Departure City' and @id='ctl00_mainContent_ddl_originStation1_CTXT']")
	    WebElement departureCity;

	    @FindBy(xpath="//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")
	    WebElement arrivalCity;

	    public void enterDepartureCity(String city) {
	        departureCity.sendKeys(city);
	    }

	    public void enterArrivalCity(String city) {
	        arrivalCity.sendKeys(city);
	    }
	
	
	
}
