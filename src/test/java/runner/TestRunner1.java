package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(utils.RetryListener.class)
@CucumberOptions
(
		features="src/test/resources/features",
		glue= {"stepdefinition","hooks"},
		plugin= {"pretty","html:target/cucumber-report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtendCucumberAdapter:"},
		monochrome=true,
		dryRun=false,
		tags="@test123 and @edge"
		)


public class TestRunner1 extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
