package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;

public class SignUpPage {
	WebDriver driver = DriverManager.getDriver();
	private static SignUpPage signUpPageInstance;

	public SignUpPage() {

	}

	By loginAccountTitle = By.xpath("//div[@class='login-form']//h2[1]");
	By loginEmailAddress = By.xpath("//input[@data-qa='login-email']");
	By loginPassword = By.xpath("//input[@data-qa='login-password']");
	By loginButton = By.xpath("//button[@data-qa='login-button']");

	By signUpTitle = By.xpath("//div[@class='signup-form']//h2[1]");
	By signUpName = By.xpath("//input[@data-qa='signup-name']");
	By signUpEmail = By.xpath("//input[@data-qa='signup-email']");
	By signUpButton = By.xpath("//button[@data-qa='signup-button']");
	By accountInfoTitle = By.xpath("(//h2[@class='title text-center']//b)[1]");
	
	By createAccountbutton = By.xpath("//button[@data-qa='create-account']");
	
	By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']//b[1]");
	By continueButton = By.xpath("//div[@class='pull-right']//a[1]");
	By accountDeletedMessage = By.xpath("//h2[@data-qa='account-deleted']//b[1]");
	
	
	public void clickContinuebutton() {
		driver.findElement(continueButton).click();

	}
	
	
	public String getSignUpTitle() {
		String signUptitle = driver.findElement(signUpTitle).getText();
		return signUptitle;
		
	}
	public String getAccountInfoTitle() {
		String accountTitle = driver.findElement(accountInfoTitle).getText();
		return accountTitle;
		
	}
	
	public void enterSignUpUsername() {
		driver.findElement(signUpName).sendKeys("Ravindran");

	}
	public void enterSignUpEmail() {
		driver.findElement(signUpEmail).sendKeys("raviqa@yopmail.com");

	}
	
	public void clickSignUpButton() {
		driver.findElement(signUpButton).click();

	}
	public void clickCreateAccountButton() {
		driver.findElement(createAccountbutton).click();

	}
	
	public String getAccountCreatedMessage() {
		String accCreatedMsg = driver.findElement(accountCreatedMessage).getText();
	return accCreatedMsg;
	}
	public String getAccountDeletedMessage() {
		String accDeletedMsg = driver.findElement(accountDeletedMessage).getText();
	return accDeletedMsg;
	}

	public static SignUpPage getInstance() {
		if (signUpPageInstance == null) {
			signUpPageInstance = new SignUpPage();

		}

		return signUpPageInstance;
	}

	

}
