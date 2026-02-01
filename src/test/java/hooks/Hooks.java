package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

    	if (scenario.isFailed()) {
    	    String screenshotPath = ScreenshotUtil.takeScreenshotAndSave(scenario.getName());
    	    scenario.attach(
    	        ScreenshotUtil.takeScreenshotAsBytes(),
    	        "image/png",
    	        scenario.getName()
    	    );
        }

        // Close browser
        DriverFactory.quitDriver();
    }
}
