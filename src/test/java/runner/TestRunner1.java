package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import hooks.Hooks;
import hooks.HooksReports;

@Listeners(utils.RetryListener.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinition", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html",
        		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun=false,
        
        tags = "@test123"
)


public class TestRunner1 extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
    @AfterSuite
    public void flushReport() {
        HooksReports.flushReport();
    }
    
    
}
