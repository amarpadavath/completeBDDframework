package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.openhtmltopdf.util.LoggerUtil;

import factory.DriverFactory;


import java.util.Collection;

public class HooksReports {
	


    @Before("@test123")
    public void setup(Scenario scenario) {

        String browser = "chrome";

        Collection<String> tags = scenario.getSourceTagNames();

        if (tags.contains("@firefox")) {
            browser = "firefox";
        } else if (tags.contains("@edge")) {
            browser = "edge";
        }

        DriverFactory.initDriver(browser);
    }

    @After("@test123")
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

      /*  if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        
        else
        {
        	
        	  byte[] screenshot = ((TakesScreenshot) driver)
                      .getScreenshotAs(OutputType.BYTES);

              scenario.attach(screenshot, "image/png", "Success Screenshot");
        	
        }*/
        
        if (driver != null) {

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName()
            );
            
            String base64 = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BASE64);

           
        }

        DriverFactory.quitDriver();
       
    }
}