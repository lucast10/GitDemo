package Pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Inheritance.AbstractMethods;

public class Cart extends AbstractMethods {
	
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='cartSection'] h3") List<WebElement> cartItems;
	@FindBy(css=".totalRow button") WebElement checkout;

	public List<WebElement> getCartItems() {
		return cartItems;
	}
	
	public void verifyCartItem(String productName) {
		
		verifyItemMatch(getCartItems(), productName);
	}
	
	public void checkOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", checkout);
	}
}
