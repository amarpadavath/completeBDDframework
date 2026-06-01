package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightBookingPage2NormalPOM {
	
	//BasePage s = new BasePage(driver);
	  WebDriver driver;
	public FlightBookingPage2NormalPOM(WebDriver driver) {
		
		this.driver= driver;
		
		
	}
	
	By departureCity = By.xpath("//input[@value='Departure City' and @id='ctl00_mainContent_ddl_originStation1_CTXT']");
    By arrivalCity = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");

    public void enterDepartureCity(String city) {
        driver.findElement(departureCity).sendKeys(city);
    }

    public void enterArrivalCity(String city) {
        driver.findElement(arrivalCity).sendKeys(city);
    }
	
	
	
}
