package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import pages.ContactUsPage;
import pages.HomePage;
import utils.CommonUtils;

public class ContactUsSteps {
	
	@When("the user clicks on the Contact Us link")
	public void the_user_clicks_on_the_contact_us_link() {
		HomePage.getInstance().clickContactusLink();  
	}
	@Then("the user should be rediected to contact us page")
	public void the_user_should_be_rediected_to_contact_us_page() {
	   boolean verifyContactHeader = ContactUsPage.getInstance().verifyContactHeader();
	   assertEquals(true, verifyContactHeader);
	   boolean verifygetinTouch= ContactUsPage.getInstance().verifyGetInTouchHeader();
	   assertEquals(true, verifygetinTouch);
	}
	@Then("the verifies the feedback mail id")
	public void the_verifies_the_feedback_mail_id() {
		String feedbackMailId = ContactUsPage.getInstance().getFeedbackMailId();
	    assertEquals("feedback@automationexercise.com", feedbackMailId);
	}

	@Then("User enters the below details")
	public void user_enters_the_below_details(DataTable dataTable) {
		Map<String, String> formData = dataTable.asMap();
		ContactUsPage.getInstance().enterName().sendKeys(formData.get("Name"));
		ContactUsPage.getInstance().enterEmail().sendKeys(formData.get("Email"));
		ContactUsPage.getInstance().enterSubject().sendKeys(formData.get("Subject"));
		ContactUsPage.getInstance().enterMessage().sendKeys(formData.get("Message"));
	
	   
	}
	@Then("the user attaching the product image")
	public void the_user_attaching_the_product_image() {
		WebElement fileInput = ContactUsPage.getInstance().getChooseFileButton();
		fileInput.sendKeys("C:\\Users\\Ravin\\Downloads\\Puma.jpg");
	}
	@Then("the user clicks on the submit button")
	public void the_user_clicks_on_the_submit_button() {
		CommonUtils.takeScreenshot("screenshot/ContactUsFor.png");
		ContactUsPage.getInstance().clickSubmitButton();
		Alert submisionAlert = DriverManager.getDriver().switchTo().alert();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		submisionAlert.accept();
	    
	}
	@Then("the user should able to see the details submitted message")
	public void the_user_should_able_to_see_the_details_submitted_message() {
		String submittedMessage = ContactUsPage.getInstance().getSubmittedMessage();
	    assertEquals("Success! Your details have been submitted successfully.", submittedMessage);
		CommonUtils.takeScreenshot("screenshot/ContactUsSubmission.png");
	}

}
