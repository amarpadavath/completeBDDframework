package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.PdfReportGenerator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		
		        features = "src/test/resources/features",
		        glue = "stepdefinitions",
		        plugin = {
		                "pretty",
		                "tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		        },
		
        monochrome = true,
        tags = "@test123"
)
public class TestRunner2grasshoperadapter extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
   
}