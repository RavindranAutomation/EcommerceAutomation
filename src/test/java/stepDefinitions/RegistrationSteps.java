package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import driverManager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import pages.HomePage;
import pages.SignUpPage;

public class RegistrationSteps {
	WebDriver driver = DriverManager.getDriver();

	@Given("the user launches the browser and navigate to the URL")
	public void the_user_launches_the_browser_and_navigate_to_the_url() {
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		System.out.println(currentUrl);
	}

	@Then("the home page should be visible successfully")
	public void the_home_page_should_be_visible_successfully() {
		try {
			boolean homeLogo = HomePage.getInstance().getHomePageLogo().isDisplayed();
			assertEquals(true, homeLogo);

			boolean displayed2 = HomePage.getInstance().getHomePageLink().isDisplayed();
			assertEquals(true, displayed2);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	@When("the user clicks on the Signup\\/Login button")
	public void the_user_clicks_on_the_signup_login_button() {
		HomePage.getInstance().getSignUpHeader().click();
	}
	@Then("they should see {string} on the page")
	public void they_should_see_on_the_page(String signUpTitleExpected) {
		String signUpTitleActual = SignUpPage.getInstance().getSignUpTitle();
		assertEquals(signUpTitleExpected, signUpTitleActual);

	}
	@When("the user enters their name and email address")
	public void the_user_enters_their_name_and_email_address() {
		SignUpPage.getInstance().enterSignUpUsername().sendKeys("Ravindran");
		SignUpPage.getInstance().enterSignUpEmail().sendKeys("raviqa@yopmail.com");

	}
	@When("clicks the Signup button")
	public void clicks_the_signup_button() {
		SignUpPage.getInstance().clickSignUpButton();

	}
	@Then("user should see {string} on the page")
	public void user_should_see_on_the_page(String accountInformessageExpected) {
		String accountInfoMessageActual = SignUpPage.getInstance().getAccountInfoTitle();
		assertEquals(accountInformessageExpected, accountInfoMessageActual);
	}
	@When("the user fills required informations for registration")
	public void the_user_fills_required_informations_for_registration() {
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("Test@12345");

		Select s = new Select(driver.findElement(By.id("days")));
		s.selectByVisibleText("10");
		Select s1 = new Select(driver.findElement(By.id("months")));
		s1.selectByVisibleText("July");
		Select s2 = new Select(driver.findElement(By.id("years")));
		s2.selectByVisibleText("2000");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("first_name")).sendKeys("Ravi");
		driver.findElement(By.id("last_name")).sendKeys("Test");
		driver.findElement(By.id("company")).sendKeys("Testing Company");
		driver.findElement(By.id("address1")).sendKeys("No:123 XYZ Street, Mumbai");
		driver.findElement(By.id("address2")).sendKeys("PO NO - 9851645, Mumbai - 400701");
		driver.findElement(By.id("state")).sendKeys("Maharastra");
		driver.findElement(By.id("city")).sendKeys("Mumbai");
		driver.findElement(By.id("zipcode")).sendKeys("400071");
		driver.findElement(By.id("mobile_number")).sendKeys("9876543210");

	}
	@When("clicks the Create Account button")
	public void clicks_the_create_account_button() {
		SignUpPage.getInstance().clickCreateAccountButton();

	}
	@Then("they should see ACCOUNT CREATED! on the page")
	public void they_should_see_account_created_on_the_page() {
		String accountCreatedMessage = SignUpPage.getInstance().getAccountCreatedMessage();
		assertEquals(accountCreatedMessage, "ACCOUNT CREATED!");
	}
	@When("the user clicks the Continue button")
	public void the_user_clicks_the_continue_button() {
		SignUpPage.getInstance().clickContinuebutton();


	}
	@Then("they should see Logged in as username")
	public void they_should_see_logged_in_as_username() {
		boolean loggedinAs = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[10]/a")).isDisplayed();
		assertEquals(true, loggedinAs);
	}

	@When("the user clicks the Delete Account button")
	public void the_user_clicks_the_delete_account_button() {
		HomePage.getInstance().clickDeleteAcc();

	}
	@Then("they should see ACCOUNT DELETED! on the page")
	public void they_should_see_account_deleted_on_the_page() {
		String accountDeletedMessage = SignUpPage.getInstance().getAccountDeletedMessage();
		assertEquals(accountDeletedMessage, "ACCOUNT DELETED!");

	}
	@Then("they click the Continue button")
	public void they_click_the_continue_button() {
		SignUpPage.getInstance().clickContinuebutton();
		boolean homeLogo1 = HomePage.getInstance().getHomePageLogo().isDisplayed();
		assertEquals(true, homeLogo1);
	}
	@SuppressWarnings("deprecation")
	@Then("they should see the error message {string}")
	public void they_should_see_the_error_message(String emailExistsMessageExpected) {
	   String emailExistsMessageActual = SignUpPage.getInstance().getEmailExistsMessage();
	   System.out.println(emailExistsMessageActual);
	  assertEquals(emailExistsMessageExpected, emailExistsMessageActual);
	}
	@When("the user enters their name and email address {string} and {string}")
	public void the_user_enters_their_name_and_email_address_and(String Username, String Password) {
	    SignUpPage.getInstance().enterSignUpUsername().sendKeys(Username);
	    SignUpPage.getInstance().enterSignUpEmail().sendKeys(Password);
	}


}
