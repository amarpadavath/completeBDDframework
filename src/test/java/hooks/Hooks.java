package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Set;

public class Hooks {

    private static final Logger log = LoggerUtil.getLogger(Hooks.class);

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

        if (scenario.isFailed()) {
            scenario.attach(
                ScreenshotUtil.takeScreenshotAsBytes(),
                "image/png",
                scenario.getName()
            );
        }
        DriverFactory.quitDriver();
    }
}
