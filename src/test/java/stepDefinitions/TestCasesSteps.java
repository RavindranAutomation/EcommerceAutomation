package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesSteps {
	@When("the user clicks on the Test Cases button")
	public void the_user_clicks_on_the_test_cases_button() {
		HomePage.getInstance().clickOnTestCases();

	}

	@Then("they should be navigated to the test cases page successfully")
	public void they_should_be_navigated_to_the_test_cases_page_successfully() {
		String testCasesHeader = TestCasesPage.getInstance().getTestCasesHeader();
		System.out.println(testCasesHeader);
		List<WebElement> listOfTC = TestCasesPage.getInstance().getListOfTC();
		for (WebElement tcList : listOfTC) {
			System.out.println(tcList.getText());
		}
	}

}
