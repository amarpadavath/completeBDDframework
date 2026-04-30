package hooks;


import io.cucumber.java.*;
import factory.DriverFactory;
import utils.BrowserContext;
import utils.ConfigReader;
import utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import org.testng.ITestResult;


public class HooksReports4 {

	@Before
	public void setup(Scenario scenario) {

	    String browser = null;

	    try {
	        // 🔥 Fetch from TestNG XML
	        browser = Reporter.getCurrentTestResult()
	                          .getTestContext()
	                          .getCurrentXmlTest()
	                          .getParameter("browser");

	        System.out.println("Browser from XML: " + browser);

	    } catch (Exception e) {
	        System.out.println("Could not fetch browser from TestNG");
	    }

	    // Fallback
	    if (browser == null || browser.isEmpty()) {
	        browser = ConfigReader.getProperty("browser");
	    }

	    if (browser == null || browser.isEmpty()) {
	        browser = "chrome";
	    }

	    System.out.println("FINAL Browser: " + browser);

	    DriverFactory.initDriver(browser);
	}

    // ✅ After Hook
    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {

            byte[] screenshot = ScreenshotUtil.captureScreenshotBytes(driver);

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.isFailed() ? "Failure Screenshot" : "Success Screenshot"
            );
        }

        DriverFactory.quitDriver(); // ✅ MUST for parallel
    }
}