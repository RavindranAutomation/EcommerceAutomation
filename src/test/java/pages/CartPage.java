package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;

public class CartPage {
	WebDriver driver = DriverManager.getDriver();
	private static CartPage cartPageInstance;

	public CartPage() {

	}

	
	
	By shoppingCartHeader = By.xpath("//li[normalize-space(text())='Shopping Cart']");
    By checkOutBtn = By.xpath("//div[@class='col-sm-6']//a[1]");
    By checkoutHeader = By.className("active");
    By addressHeader = By.xpath("(//h2[@class='heading'])[1]");
    By reviewOrderHeader = By.xpath("(//h2[@class='heading'])[2]");
    By totalAmount = By.xpath("(//p[@class='cart_total_price'])[2]");
    By textArea = By.xpath("//div[@class='form-group']//textarea[1]");
    By placeOrderbtn = By.xpath("//a[@href='/payment']");
    
    public boolean verfiyShoppingCartHeader() {
    	return driver.findElement(shoppingCartHeader).isDisplayed();
    }
    
    public void clickCheckoutBtn() {
		driver.findElement(checkOutBtn).click();

	}
    public boolean verfiyCheckoutHeader() {
    	return driver.findElement(checkoutHeader).isDisplayed();

	}
    public boolean verfiyaddressHeader() {
    	return driver.findElement(addressHeader).isDisplayed();

	}
    
    public String getTotalAmount() {
		String text = driver.findElement(totalAmount).getText();
		return text;
	}
    public static CartPage getInstance() {
		if (cartPageInstance == null) {
			cartPageInstance = new CartPage();

		}

		return cartPageInstance;
	}
}
