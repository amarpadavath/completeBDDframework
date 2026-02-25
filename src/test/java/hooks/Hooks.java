/*package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.Collection;
import java.util.Set;

public class Hooks {

    private static final Logger log = LoggerUtil.getLogger(Hooks.class);
    
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {

        String browser = "chrome"; // default fallback

        Collection<String> tags = scenario.getSourceTagNames();

        if (tags.contains("@firefox")) {
            browser = "firefox";
        } else if (tags.contains("@edge")) {
            browser = "edge";
        }

        log.info("Starting scenario: {} on browser: {}",
                 scenario.getName(), browser);

        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {


      

        if (test != null) {

            if (scenario.isFailed()) {
                test.fail("Test Failed");
            } else {
                test.pass("Test Passed");
            }
        }

        extent.flush();
       
        DriverFactory.quitDriver();
    }
}*/
