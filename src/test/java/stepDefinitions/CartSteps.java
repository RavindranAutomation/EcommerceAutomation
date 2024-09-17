package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class CartSteps {
	@Then("the user adds the Blue top to cart")
	public void the_user_adds_the_blue_top_to_cart() {
		ProductsPage.getInstance().addBlueTopsToCart();
		ProductsPage.getInstance().clickContinueButton();
	}


	@When("user clicks on Cart header link")
	public void user_clicks_on_cart_header_link() {
	    HomePage.getInstance().clickCartHeader();
	}

	@Then("Shopping cart page should be displayed")
	public void shopping_cart_page_should_be_displayed() {
	    CartPage.getInstance().verfiyShoppingCartHeader();
	}

	@When("user click on the Proceed to checkout button")
	public void user_click_on_the_proceed_to_checkout_button() {
		CartPage.getInstance().clickCheckoutBtn();
	}

	@When("checkout page should be dispalyed")
	public void checkout_page_should_be_dispalyed() {
		CartPage.getInstance().verfiyCheckoutHeader();
	}

	@When("user verfifies the cart items and total amount {string}")
	public void user_verfifies_the_cart_items_and_total_amount(String total) {
		String totalAmount = CartPage.getInstance().getTotalAmount();
		Assert.assertEquals(total, totalAmount);
	   
	}

}
