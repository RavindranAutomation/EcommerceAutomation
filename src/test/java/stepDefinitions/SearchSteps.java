package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;

public class SearchSteps {
	@When("user search the {string} product")
	public void user_search_the_product(String productName) {
	    ProductsPage.getInstance().getSearchBox().click();
	    ProductsPage.getInstance().getSearchBox().sendKeys(productName);
	    ProductsPage.getInstance().clickSearchButon();
	}

	@Then("user should see the first product results")
	public void user_should_see_the_first_product_results() {
		boolean verfiySearchResultsHeader = ProductsPage.getInstance().verfiySearchResultsHeader();
	    Assert.assertEquals(true, verfiySearchResultsHeader);
	    boolean verifyCottonTshirt = ProductsPage.getInstance().verifyCottonTshirt();
	    Assert.assertEquals(true, verifyCottonTshirt);
	}


}
