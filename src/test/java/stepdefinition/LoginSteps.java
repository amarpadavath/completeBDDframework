package stepdefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.openLoginPage();
    }

    @When("user logs in with valid username and password")
    public void user_logs_in() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
    }

    @Then("user should see successful login message")
    public void verify_login() {
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
}
