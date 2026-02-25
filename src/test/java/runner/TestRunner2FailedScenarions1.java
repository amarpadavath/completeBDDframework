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
        			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        			    "rerun:target/failed_scenarios.txt"
        			},
        monochrome = true,
        tags = "@test123"
)
public class TestRunner2FailedScenarions1 extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
    @AfterSuite
    public void generatePdfReport() {
        PdfReportGenerator.generatePdf();
    }
}