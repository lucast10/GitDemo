package Pom;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
	/*@DataProvider
	public Object[][] getData() {
		return new Object [][] {
			{"thankyou for the order.","Argentina","test@test.com","testing","ZARA COAT 3","ADIDAS ORIGINAL"},
			{"thankyou for the order.","Argentina","test@test.com","testing","ZARA COAT 3","ADIDAS ORIGINAL"},
			{"thankyou for the order.","Argentina","test@test.com","testing","ZARA COAT 3","ADIDAS ORIGINAL"}
		};
	}*/
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		/*HashMap<String,String> map = new HashMap<String,String>();
		map.put("message", "thankyou for the order.");
		map.put("countryName", "Argentina");
		map.put("email", "test@test.com");
		map.put("pass", "testing");
		map.put("productName", "ZARA COAT 3");
		map.put("productName2", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("message", "thankyou for the order.");
		map1.put("countryName", "Argentina");
		map1.put("email", "test@test.com");
		map1.put("pass", "testing");
		map1.put("productName", "ZARA COAT 3");
		map1.put("productName2", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("message", "thankyou for the order.");
		map2.put("countryName", "Argentina");
		map2.put("email", "test@test.com");
		map2.put("pass", "testing");
		map2.put("productName", "ZARA COAT 3");
		map2.put("productName2", "ADIDAS ORIGINAL");
		
		return new Object [][] {
			{map},
			{map1},
			{map2}
		};*/
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\Purchase.json");
		
		
		return new Object [][] {
			{data.get(0)},
			{data.get(1)}
		};
	}
	
	public File takeScreenshot(String testCaseName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return file;
	}
	
	@Test(dataProvider = "getData") //, groups = {"Purchase"}
	public void submitOrder(HashMap<String,String> input) throws IOException {
		
		//String productName = "ZARA COAT 3";
		//String productName2 = "ADIDAS ORIGINAL";
		//String countryName = "Argentina";
		
		loginPage.loginAs(input.get("email"), input.get("password"));
		ProductCatalogue products = new ProductCatalogue(driver);
		products.getProduct(input.get("product"));
		products.addProductToCart(input.get("product"));
		products.goToCart();
		Cart cart = new Cart(driver);
		cart.getCartItems();
		cart.verifyCartItem(input.get("product"));
		cart.checkOut();
		Payment pay = new Payment(driver);
		pay.selectCountry(input.get("countryName"));
		pay.placeOrder();
		String match = pay.verifyOrder();
		Assert.assertTrue(match.equalsIgnoreCase(input.get("message")));
		
	}
}
