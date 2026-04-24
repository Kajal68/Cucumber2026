package TestNGRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "stepDefinition", monochrome = true, plugin = {
		"pretty", "html:target/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", })
public class FailedTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() { // to run parallel tests
		return super.scenarios();
	}
}
//AbstractTestNGCucumberTests: A base class provided by Cucumber that integrates with TestNG (a testing framework). 
//Extending this class allows you to run Cucumber feature files as TestNG tests.

//CucumberOptions: An annotation used to configure how Cucumber should run 
//(where to find features, step definitions, reporting options, etc.)...

//monochrome = true: Makes console output cleaner and more readable (removes extra characters).

//"pretty" → Prints readable output in the console.

//@CucumberOptions(feature ="src/test/java/features", glue ="steDefinition",monochrome = true, plugin={"pretty", "html"target)
//dryRun = true = Quickly verifies that all steps in your feature files have matching step definitions.

//tags = "@placeOrder or @orderPage"
//json:target/cucumber.json" for reports