package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.PdfReportGenerator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		
		        features = "@target/failed_scenarios.txt",
		        glue = {"stepdefinition", "hooks"},
		        plugin = {"pretty"},
		
        monochrome = true,
        tags = "@test123"
)
public class TestRunner2FailedScenarions2 extends AbstractTestNGCucumberTests {

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