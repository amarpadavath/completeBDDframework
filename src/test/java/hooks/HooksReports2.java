package hooks;

import io.cucumber.java.*;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import factory.DriverFactory;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.Base64;
import java.util.Collection;

public class HooksReports2 {

    private static ExtentReports extent = ExtentManager.getInstance();

    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> step = new ThreadLocal<>();

    // ✅ SCENARIO LEVEL
    @Before()
    public void setup(Scenario scenario) {

        String browser = "chrome";

        Collection<String> tags = scenario.getSourceTagNames();

        if (tags.contains("@firefox")) {
            browser = "firefox";
        } else if (tags.contains("@edge")) {
            browser = "edge";
        }

        if (DriverFactory.getDriver() == null) {
            DriverFactory.initDriver(browser);
        }

        ExtentTest scenarioTest = extent.createTest(scenario.getName());
        test.set(scenarioTest);
    }

    // ✅ STEP LEVEL (IMPORTANT – FIX FOR YOUR ERROR)
    @BeforeStep()
    public void beforeStep(Scenario scenario) {

        if (test.get() == null) {
            System.out.println("Test is NULL → check @Before hook");
            return;
        }

        // You can improve name later
        ExtentTest stepNode = test.get().createNode("Step Execution");
        step.set(stepNode);
    }

    // ✅ STEP RESULT
    @AfterStep()
    public void afterStep(Scenario scenario) {

        if (step.get() == null) {
            System.out.println("Step is NULL → initialization issue");
            return;
        }

        if (scenario.isFailed()) {
            step.get().fail("Step Failed");
        } else {
            step.get().pass("Step Passed");
        }
    }

    // ✅ SCENARIO RESULT
    @After("")
  
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();
        String base64Screenshot = ScreenshotUtil.captureScreenshot(driver);

        // ✅ 1. Manual Extent Report (KEEP YOUR EXISTING)
        if (scenario.isFailed()) {
            test.get().fail("Test Failed")
                    .addScreenCaptureFromBase64String(base64Screenshot);
        } else {
            test.get().pass("Test Passed")
                    .addScreenCaptureFromBase64String(base64Screenshot);
        }

        // ✅ 2. Adapter Report (ADD THIS NEW)
        if (driver != null) {
        if (base64Screenshot != null) {

        	byte[] screenshotBytes = ScreenshotUtil.captureScreenshotBytes(driver);

            scenario.attach(
                    screenshotBytes,
                    "image/png",
                    scenario.isFailed() ? "Failure Screenshot" : "Success Screenshot"
            );

        }
        }

        extent.flush();
       // DriverFactory.quitDriver();
    }
}