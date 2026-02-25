package stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DataTablePage;

public class DataTableStepDefinition {

	WebDriver driver;
	DataTablePage dataTablePage;
	SoftAssert softAssert = new SoftAssert();

	@Given("User is on the User Creation page")
	public void user_is_on_creation_page() {

		driver = DriverFactory.getDriver();

		dataTablePage = new DataTablePage(driver);

		dataTablePage.launchApp();

	}

	@When("User enters the following details")
	    public void user_enters_the_following_details(DataTable dataTable) {
		 
		 List<Map<String,String>> userList =  dataTable.asMaps(String.class,String.class);
		 
		 for(Map<String,String> user : userList)
		 {
			 
			 dataTablePage.enterFirstName(user.get("firstname"));
			 dataTablePage.enterLastName(user.get("lastname"));
			 dataTablePage.enterEmail(user.get("email"));
			 dataTablePage.clickOnMaleRadionMaleBtn();
			 dataTablePage.enterMobileno(user.get("mobilenumber"));
			// dataTablePage.clickSubmit();
		 }
			 
			 
			 
		 }
	
    @When("User enters {string} {string} {string} {string}")
    public void user_enters_details(String firstName,
                                    String lastName,
                                    String email,
                                    String mobileNumber) {

        dataTablePage.enterFirstName(firstName);
        dataTablePage.enterLastName(lastName);
        dataTablePage.enterEmail(email);
        dataTablePage.enterMobileno(mobileNumber);

        dataTablePage.clickOnMaleRadionMaleBtn();
        dataTablePage.clickSubmit();
    }

	@Then("User should be created successfully")
	public void user_created_successfully() {

		softAssert.assertAll();
	}

}
