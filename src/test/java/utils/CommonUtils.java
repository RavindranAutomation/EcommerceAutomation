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
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchResultsPage;

public class CommonUtils {

	public static void loadProperties() {
		FileReader file = null;
		try {
			file = new FileReader("src/test/resources/config.properties");
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
		Cons.Email = p.getProperty("Email");
		Cons.Password = p.getProperty("Password");

	}
	
	public static void initWebElement() {
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), MyAccountPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SearchResultsPage.getInstance());

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
