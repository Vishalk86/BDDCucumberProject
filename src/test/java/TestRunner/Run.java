package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



// @RunWith(Cucumber.class)
@CucumberOptions
 (
     features = {".//Features/LoginFeature.feature"},  // Given Path - Which feature files we execute.
     //features = ".//Features/",  // Give path till Folder name, To run all feature files in Features folder.
	 glue = "StepDefinition", // Folder Name - Where Step Definition Files available. Cucumber search in this Folder for feature file steps implementation
	 dryRun = false, // If 'true' - then check mapping of Feature and Step Definition files (All are implemented or not). If false - then execute feature file
	 monochrome = true, // true - To print output in readable format in console we use monochrome with true
	 //tags = "@Sanity", // To run only test cases under @Regression tag
	 //plugin = {"pretty", "html:target/cucumber-reports/report_html.html"}
	 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

// plugin = {"pretty", "json:target/cucumber-reports/report_json.json"}
// plugin = {"pretty", "junit:target/cucumber-reports/report_xml.xml"}



public class Run extends AbstractTestNGCucumberTests{
// This class will be empty.
}
