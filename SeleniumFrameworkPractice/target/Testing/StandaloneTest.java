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

import Pom.LoginPage;

public class StandaloneTest {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		
		  options.addArguments("--disable-password-manager-leak-detection"); // Disables the password leak detection feature
		    options.setExperimentalOption("prefs",  new HashMap<String, Object>() {{
		        put("credentials_enable_service", false); // Disables the "Offer to save passwords" prompt
		        put("profile.password_manager_leak_detection", false); // Disables the "Unsafe Password" warning
		    }});
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.findElement(By.id("userEmail")).sendKeys("test@test.com");
		driver.findElement(By.id("userPassword")).sendKeys("testing");
		driver.findElement(By.id("login")).click();
		
		/*List<WebElement> items = driver.findElements(By.className(".mb-3"));
		
		//items.stream().filter(products -> products.getText().equals("ZARA COAT 3")); the text is inside a b
		
		WebElement prod = items.stream().filter(products -> 
		products.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='card-body']//b")));
		
		prod.findElement(By.xpath(".//div[@class='card-body']//b")).click();*/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));						
		
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));	    
		WebElement prod = products.stream().filter(product->		
		 product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);		
		prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();	
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ngx-spinner-overlay")));
	
		WebElement prod2 = products.stream().filter(product ->
		 product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		prod2.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ngx-spinner-overlay")));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']")));
		WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']")));
		item.click();
		
		List<WebElement> cartItems = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
		
		Boolean match = cartItems.stream().anyMatch(products2 -> 
		 products2.getText().equals("ZARA COAT 3"));
		
		Assert.assertTrue(match);
		
		Boolean match2 = cartItems.stream().anyMatch(products3 -> 
		 products3.getText().equals("ADIDAS ORIGINAL"));
		
		Assert.assertTrue(match2);
		
		WebElement checkout = driver.findElement(By.cssSelector(".totalRow button"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", checkout);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select Country']")));
		
		Actions a = new Actions(driver);
		
		WebElement dropdown = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
		
		a.sendKeys(dropdown, "Argentina").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results button")));
		
		driver.findElement(By.cssSelector(".ta-results button")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
		
		WebElement placeorder = driver.findElement(By.cssSelector(".action__submit"));

		JavascriptExecutor js2 = (JavascriptExecutor) driver;

		js2.executeScript("arguments[0].click();", placeorder);
		
	
		
		String texto = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		
		
		Assert.assertTrue(texto.equalsIgnoreCase("thankyou for the order."));
		
		driver.quit();
		
		
	}

}
