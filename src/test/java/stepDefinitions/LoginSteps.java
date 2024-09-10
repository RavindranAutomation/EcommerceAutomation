package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignUpPage;

public class LoginSteps {
	@Given("User launches the application")
	public void user_launches_the_application() {
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		System.out.println(currentUrl);
		
	}

	@Given("the user enters the valid credentials {string} and {string}")
	public void the_user_enters_the_valid_credentials_and(String email, String password) {
		HomePage.getInstance().getSignUpHeader().click();
		SignUpPage.getInstance().enterLoginEmail().sendKeys(email);
		SignUpPage.getInstance().enterPassword().sendKeys(password);

	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		SignUpPage.getInstance().clickLoginButton();
		
	}

	@Then("the user should able to see the logout account link")
	public void the_user_should_able_to_see_the_logout_account_link_() {
		boolean verifyDeleteAccLink = HomePage.getInstance().verifyLogoutAccLink();
		Assert.assertEquals(true, verifyDeleteAccLink);
		HomePage.getInstance().clickLogoutLink();

	}

	@Given("the user enters the invalid credentials {string} and {string}")
	public void the_user_enters_the_invalid_credentials_and(String email, String password) {
		SignUpPage.getInstance().enterLoginEmail().sendKeys(email);
		SignUpPage.getInstance().enterPassword().sendKeys(password);
	}

	@Then("the user should able to see invalid login error message")
	public void the_user_should_able_to_see_invalid_login_error_message() {
		String loginErrorMessage = SignUpPage.getInstance().getLoginErrorMessage();

		Assert.assertEquals("Your email or password is incorrect!", loginErrorMessage);
		
	}

}
