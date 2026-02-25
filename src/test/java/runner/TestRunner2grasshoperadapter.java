package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.PdfReportGenerator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinition", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter"
        },
        monochrome = true,
        tags = "@test123"
)
public class TestRunner2grasshoperadapter extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
   
}