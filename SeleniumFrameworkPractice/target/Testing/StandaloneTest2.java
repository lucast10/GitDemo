package Testing;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Inheritance.AbstractMethods;
import Pom.Cart;
import Pom.LoginPage;
import Pom.Payment;
import Pom.ProductCatalogue;

public class StandaloneTest2 {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		
		ChromeOptions options = new ChromeOptions();
		
		  options.addArguments("--disable-password-manager-leak-detection"); // Disables the password leak detection feature
		    options.setExperimentalOption("prefs",  new HashMap<String, Object>() {{
		        put("credentials_enable_service", false); // Disables the "Offer to save passwords" prompt
		        put("profile.password_manager_leak_detection", false); // Disables the "Unsafe Password" warning
		    }});
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String productName = "ZARA COAT 3";
		String productName2 = "ADIDAS ORIGINAL";
		String countrySelection = "Argentina";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo();
		loginPage.loginAs("test@test.com", "testing");
		
		
		AbstractMethods abstractCall = new AbstractMethods(driver);
		abstractCall.waitElementVisibility(By.cssSelector(".mb-3"));
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		//List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.getProduct(productName);
		productCatalogue.addProductToCart(productName);
		productCatalogue.getProduct(productName2);
		productCatalogue.addProductToCart(productName2);
		productCatalogue.goToCart();
		Cart cart = new Cart(driver);
		cart.verifyCartItem(productName);
		cart.verifyCartItem(productName2);
		cart.checkOut();
		Payment pay = new Payment(driver);
		pay.selectCountry(countrySelection);
		pay.placeOrder();
		pay.verifyOrder();
		
		driver.quit();
		
		
	}

}
