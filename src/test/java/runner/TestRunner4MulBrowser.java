package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.BrowserContext;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinition", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@test123"
)
public class TestRunner4MulBrowser extends AbstractTestNGCucumberTests {

    // 🔥 THIS IS THE IMPORTANT PART
    @BeforeTest
   
    public void setBrowser(ITestContext context) {
        String browser = context.getCurrentXmlTest().getParameter("browser");
        BrowserContext.setBrowser(browser);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}