package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPageWaitUtil extends BasePageWaits{
	
	

	    public FlightBookingPageWaitUtil(WebDriver driver) {
	        super(driver);
	    }

	    @FindBy(id="departure")
	   private WebElement departureCity;
	    
	    By test = By.xpath("test");

	    public void enterDepartureCity(String city) {

	        waitUtil.waitForPrsesence(test);
	        waitUtil.elementToBeClickable(departureCity);
	        departureCity.sendKeys(city);
	    }
	}