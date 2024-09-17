package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverManager.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductsPage;

public class ProductSteps {
	WebDriver driver = DriverManager.getDriver();
	@Given("the user launches the browser and navigate to the URL")
	public void the_user_launches_the_browser_and_navigate_to_the_url() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	@Then("the user should be navigated to home page")
	public void the_user_should_be_navigated_to_home_page() {
		boolean verifyLogoutAccLink = HomePage.getInstance().verifyLogoutAccLink();
		Assert.assertEquals(true, verifyLogoutAccLink);

	}

	@When("the user clicks on the Products button")
	public void the_user_clicks_on_the_Products_button() {
		HomePage.getInstance().clickonProductsLink();

	}

	@Then("they should be navigated to the ALL PRODUCTS page successfully")
	public void they_should_be_navigated_to_the_all_products_page_successfully() {

		boolean verifyHeader = ProductsPage.getInstance().verifyHeader();
		assertEquals(true, verifyHeader);

		boolean verifyBannerImg = ProductsPage.getInstance().verifyBannerImg();
		assertEquals(true, verifyBannerImg);
	}

	@Then("the products list should be visible")
	public void the_products_list_should_be_visible() {
		List<WebElement> allProductsList = ProductsPage.getInstance().getAllProductsList();
		int totalProducts = allProductsList.size();
		assertEquals(34, totalProducts);
		for (WebElement productsList : allProductsList) {
			System.out.println("Products Names:  " + productsList.getText().toString());

		}

	}

	@When("user clicks on the View Product link of the MenTshirt")
	public void user_clicks_on_the_view_product_link_of_the_men_tshirt() {
		ProductsPage.getInstance().clickOnmenTshirtView();

	}

	@Then("the user should be landed on the MenTshirt detail page")
	public void the_user_should_be_landed_on_the_men_tshirt_detail_page() {
		boolean verifyWriteReview = ProductsPage.getInstance().verifyWriteReview();
		assertEquals(true, verifyWriteReview);
	}

	@Then("the user verifies the below details")
	public void the_user_verifies_the_below_details(DataTable dataTable) {
		Map<String, String> details = dataTable.asMap();
		assertEquals("Men Tshirt", details.get("Product Name"));
		assertEquals("Category: Men > Tshirts", details.get("Category"));
		assertEquals("Rs. 400", details.get("Price"));
		assertEquals("In Stock", details.get("Availability"));
		assertEquals("New", details.get("Condition"));
		assertEquals("H&M", details.get("Brand"));

	}

}
