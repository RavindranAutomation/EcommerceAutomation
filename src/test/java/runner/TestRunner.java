package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/resources/FeatureFiles",
		glue= {"stepDefinitions","hooks"},
//		tags = "@ExistingUserRegistration",
		dryRun=!true,
		stepNotifications=true,
		monochrome=true,
		publish = true,

		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedscenario.txt",
				"html:target/html/Cucumber.html",
				"json:target/json/Cucumber.json"}

		)

public class TestRunner {

}
