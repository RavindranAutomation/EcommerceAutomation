package stepDefinitions;

import org.openqa.selenium.Keys;

import io.cucumber.java.en.When;
import org.junit.*;
import pages.HomePage;

public class SubscriptionSteps {
	@When("user goes to subscripton text box and enters email {string}")
	public void user_goes_to_subscripton_text_box_and_enters_email(String email) {
	    HomePage.getInstance().verifySubscriptionHeader();
	    HomePage.getInstance().enterEmailInSubsTxtBox().sendKeys(email + Keys.ENTER);
	}
	@When("user shold see the subscription success mesage")
	public void user_shold_see_the_subscription_success_mesage() {
		boolean displayed = HomePage.getInstance().getSubscriptionSuccessMessage().isDisplayed();
	   Assert.assertEquals(displayed, true);
	}

}
