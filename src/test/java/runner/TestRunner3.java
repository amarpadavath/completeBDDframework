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
        			    "json:target/cucumber.json"
        			},
        monochrome = true,
        tags = "@test123"
)
public class TestRunner3 extends AbstractTestNGCucumberTests {

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