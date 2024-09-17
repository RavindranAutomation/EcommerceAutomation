package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	By testCasesHeaderLink = By.xpath("//a[@href='/test_cases']");
	By productsLink = By.xpath("//a[@href='/products']");

	By subscriptionHeader = By.xpath("//div[@class='single-widget']//h2[1]");
	By subscriptionTextBox = By.xpath("//input[@type='email']");
	By subscriptionSuccessMessage = By.xpath("//div[@class='alert-success alert']");
	
	By cartHeaderLink = By.xpath("(//a[@href='/view_cart'])[1]");
    
	public void clickCartHeader() {
		driver.findElement(cartHeaderLink).click();

	}

	public boolean verifySubscriptionHeader() {
		WebElement element = driver.findElement(subscriptionHeader);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		return driver.findElement(subscriptionHeader).isDisplayed();

	}

	public WebElement enterEmailInSubsTxtBox() {
		return driver.findElement(subscriptionTextBox);

	}
	
	public WebElement getSubscriptionSuccessMessage(){
		return driver.findElement(subscriptionSuccessMessage);
	}

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

	public void clickOnTestCases() {
		driver.findElement(testCasesHeaderLink).click();

	}

	public void clickonProductsLink() {
		driver.findElement(productsLink).click();

	}

	public static HomePage getInstance() {
		if (homePageInstance == null) {
			homePageInstance = new HomePage();

		}

		return homePageInstance;
	}




}
