package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataTablePage {
	
	
	WebDriver driver;
	
	public DataTablePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By firstName = By.xpath("//input[@id='firstName']");
	By lastName = By.xpath("//input[@id='lastName']");
	By userEmail = By.xpath("//input[@id='userEmail']");
	By radioBtnMale = By.xpath("//input[@id='gender-radio-1']");
	By mobileNo = By.xpath("//input[@id='userNumber']");
	By submitBtn = By.xpath("//button[@id='submit']");
	
	public void launchApp()
	{
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
	}
	

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail) {
        driver.findElement(userEmail).sendKeys(mail);
    }
    
    public void clickOnMaleRadionMaleBtn()
    {
    	driver.findElement(radioBtnMale).click();
    }

    public void enterMobileno(String mobile) {
        driver.findElement(mobileNo).sendKeys(mobile);
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }
    
    

}
