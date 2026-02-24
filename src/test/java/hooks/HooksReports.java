package hooks;

import com.aventstack.extentreports.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class HooksReports {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Before("@test123")
    public void setup(Scenario scenario) {

        synchronized (Hooks.class) {
            ExtentTest test = extent.createTest(scenario.getName());
            testThread.set(test);
        }
    }

    @After("@test123")
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        if (testThread.get() != null) {

            String screenshot = ScreenshotUtil.captureScreenshot(driver);

            if (scenario.isFailed()) {
                testThread.get().fail("Test Failed")
                        .addScreenCaptureFromBase64String(screenshot);
            } else {
                testThread.get().pass("Test Passed")
                        .addScreenCaptureFromBase64String(screenshot);
            }
        }

        driver.quit();
        testThread.remove();
    }

    public static void flushReport() {
        extent.flush();
    }
}