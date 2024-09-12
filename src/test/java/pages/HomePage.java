package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverManager.DriverManager;

public class HomePage {
	WebDriver driver = DriverManager.getDriver();
	private static HomePage homePageInstance;

	public HomePage() {

	}

	By homePageLogo = By.xpath("//div[@class='logo pull-left']//img[1]");
	By homePageLink = By.xpath("//a[normalize-space(text())='Home']");
	By signUpHeader = By.xpath("//a[@href='/login']");
	By productsHeader = By.xpath("//a[@href='/products']");
	By cartHeader = By.xpath("//a[@href='/view_cart']");
	By contactUsLink = By.xpath("//a[@href='/contact_us']");
	By deleteAccountLink= By.xpath("//a[@href='/delete_account']");
	
	By logoutLink = By.xpath("//a[@href='/logout']");
	
	public void clickDeleteAcc() {
		driver.findElement(deleteAccountLink).click();
	}

	public boolean verifyLogoutAccLink() {
		 return driver.findElement(logoutLink).isDisplayed();

	}

	public WebElement getHomePageLogo() {
		return driver.findElement(homePageLogo);

	}
	public WebElement getSignUpHeader() {
		return driver.findElement(signUpHeader);

	}
	
	public void clickLogoutLink() {
		driver.findElement(logoutLink).click();
	}
	


	public WebElement getHomePageLink() {
		return driver.findElement(homePageLink);
	}
	
	public void clickContactusLink() {
		driver.findElement(contactUsLink).click();

	}

	public static HomePage getInstance() {
		if (homePageInstance == null) {
			homePageInstance = new HomePage();

		}

		return homePageInstance;
	}




}
