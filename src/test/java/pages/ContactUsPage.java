package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverManager.DriverManager;

public class ContactUsPage {
	WebDriver driver = DriverManager.getDriver();
	private static ContactUsPage contactUsPageInstance;

	public ContactUsPage() {

	}

	public static ContactUsPage getInstance() {
		if (contactUsPageInstance == null) {
			contactUsPageInstance = new ContactUsPage();

		}

		return contactUsPageInstance;
	}

	By contactUsHeader = By.xpath("(//h2[@class='title text-center'])[1]");
	By getInTouchHeader = By.xpath("(//h2[@class='title text-center'])[2]");
	By nameTextBox = By.xpath("//input[@data-qa='name']");
	By emailTextBox = By.xpath("//input[@data-qa='email']");
	By subjectTextBox = By.xpath("//input[@data-qa='subject']");
	By messageTextBox = By.xpath("//textarea[@data-qa='message']");
	By chooseFileButton = By.xpath("//input[@type='file']");

	By contactUsSubmitBtn = By.xpath("//input[@data-qa='submit-button']");
	By detailsSubmittedSuccessMessage = By.xpath("(//div[@class='contact-form']//div)[2]");
	By feedbackHeading = By.xpath("//div[@class='contact-info']//h2[1]");
	By feedbackMailId = By.xpath("//a[@href='mailto:feedback@automationexercise.com']");

	public boolean verifyContactHeader() {
		boolean displayed = driver.findElement(contactUsHeader).isDisplayed();
		return displayed;
	}

	public boolean verifyGetInTouchHeader() {
		boolean displayed = driver.findElement(getInTouchHeader).isDisplayed();
		return displayed;
	}
	public WebElement getChooseFileButton() {

		return driver.findElement(chooseFileButton);
	}

	public String getFeedbackMailId() {
		String mailID = driver.findElement(feedbackMailId).getText();
		return mailID;
	}

	public WebElement enterName() {
		return driver.findElement(nameTextBox);

	}

	public WebElement enterEmail() {
		return driver.findElement(emailTextBox);

	}

	public WebElement enterSubject() {
		return driver.findElement(subjectTextBox);

	}

	public WebElement enterMessage() {
		return driver.findElement(messageTextBox);

	}

	public void clickSubmitButton() {
		driver.findElement(contactUsSubmitBtn).click();

	}

	public String getSubmittedMessage() {
		String text = driver.findElement(detailsSubmittedSuccessMessage).getText();
		return text;
	}

}
