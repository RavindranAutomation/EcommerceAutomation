package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constants.Cons;
import driverManager.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonUtils;

public class Hooks {

	@Before
	public void beforeScenario() {
		CommonUtils.loadProperties();
		if (DriverManager.getDriver() == null) {
			DriverManager.launchBrowser();
			launchApplication();
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			CommonUtils.initWebElement();
		}

	}

	@AfterStep
	public static void takeScreenshot(Scenario scenario) {
		String scenarioName = scenario.getName();
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed Scenario" + scenarioName);
		}

	}

	public static void launchApplication() {

		DriverManager.getDriver().get(Cons.Url);

	}

	@AfterAll
	public static void tearDown() {
		DriverManager.getDriver().quit();
	}
}
