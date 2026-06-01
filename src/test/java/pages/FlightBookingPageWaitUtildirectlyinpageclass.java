package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtil;

public class FlightBookingPageWaitUtildirectlyinpageclass {
	
	
	   WebDriver driver;
	    WaitUtil waitUtil;

	    public FlightBookingPageWaitUtildirectlyinpageclass(WebDriver driver) {

	        this.driver = driver;
	        waitUtil = new WaitUtil(driver);
	    }
	}