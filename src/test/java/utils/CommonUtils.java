package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import constants.Cons;
import driverManager.DriverManager;
import pages.CartPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductsPage;
import pages.SignUpPage;
import pages.TestCasesPage;

public class CommonUtils {

	public static void loadProperties() {
		FileReader file = null;
		try {
			file = new FileReader("src/test/resources/Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cons.BrowserName = p.getProperty("Browser");
		Cons.Url = p.getProperty("Url");

	}
	
	public static void initWebElement() {
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SignUpPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), CartPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), ProductsPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), TestCasesPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), ContactUsPage.getInstance());

	}
	
	public static void takeScreenshot(String screenshotNameWithExtension) {
		TakesScreenshot screenshot= (TakesScreenshot)DriverManager.getDriver();
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(screenshotNameWithExtension));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
