package stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EvenHubPage;
import utils.ConfigReader;

public class EventHubSteps {
	
	WebDriver driver;
	
	EvenHubPage evenHubPage ;
	

	@Given("launch url")
	public void launch_url() {
		// Write code here that turns the phrase above into concrete actions
		 driver = DriverFactory.getDriver();   
		
		evenHubPage = new EvenHubPage(driver);
		
		evenHubPage.launchApp();
		
		
	}

	@When("User enters email {string} , password {string}, confirmpassword {string}")
	public void user_enters_email_password_confirmpassword(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		
		evenHubPage.clickOnReg();
		evenHubPage.sendEmail(string);
		evenHubPage.sendPassword(string2);
		evenHubPage.confirmPassword(string3);
		evenHubPage.clickOnCreateAccount();
		
	}
	
	@When("User enters {string} , {string},  {string}")
	public void user_enters(String string, String string2, String string3) {
		evenHubPage.clickOnReg();
		evenHubPage.sendEmail(string);
		evenHubPage.sendPassword(string2);
		evenHubPage.confirmPassword(string3);
		evenHubPage.clickOnCreateAccount();
	    
	}
	
	@When("User enters details")
	public void user_enters_details(DataTable dataTable) {
		  evenHubPage.clickOnReg();
	  List<Map<String,String>> map = dataTable.asMaps();
	  
	  for(Map<String, String> row : map)
	  {
		  String email = row.get("email");
		  String password = row.get("password");
		  String confirmpassword = row.get("confirmpassword");
		  
		
			evenHubPage.sendEmail(email);
			evenHubPage.sendPassword(password);
			evenHubPage.confirmPassword(confirmpassword);
			evenHubPage.clickOnCreateAccount();
	  }
	  
	  
	 
	}
	@When("User enters detailss")
	public void user_enters_detailss(DataTable dataTable) {
		  evenHubPage.clickOnReg();
	  List<List<String>> map = dataTable.asLists();
	  
	  for(List<String> row : map)
	  {
		  String email = row.get(0);
		  String password = row.get(1);
		  String confirmpassword = row.get(2);
		  
		
			evenHubPage.sendEmail(email);
			evenHubPage.sendPassword(password);
			evenHubPage.confirmPassword(confirmpassword);
			evenHubPage.clickOnCreateAccount();
	  }
	  
	  
	 
	}
	
	@When("User enters using property file")
	public void User_enters_using_property_file() {
		evenHubPage.clickOnReg();
		
		 String email = ConfigReader.getProperty("email");
		    String password = ConfigReader.getProperty("password");
		String confirmpassword = ConfigReader.getProperty("confirmpassword");
		
		evenHubPage.sendEmail(email);
		evenHubPage.sendPassword(password);
		evenHubPage.confirmPassword(confirmpassword);
		evenHubPage.clickOnCreateAccount();
	    
	}
	@Then("validation of user created success")
	public void validation_of_user_created_success() {
		// Write code here that turns the phrase above into concrete actions
		
		System.out.println("success");
		
		
		
	}

}
