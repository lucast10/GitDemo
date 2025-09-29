import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class ArrayCart {

	public static void main(String[] args) throws InterruptedException {
		
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] items = {"Brocolli","Cucumber"};
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.product-name")));
		List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
	
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			List nameProducts = Arrays.asList(items);
			
			
			if (nameProducts.contains(formattedName)) {
				
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if (j==items.length) {
					break;
				}
				
			}
			
		}
		//driver.quit();
	}*/
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	String[] items = {"Brocolli", "Cucumber"};
	
	ArrayCart a = new ArrayCart();
	a.processing(driver, items);

	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[class='promoCode']")));
	driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span[class='promoInfo']")));
	System.out.print(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
	
	
	}
	
	public void processing (WebDriver driver, String[] items) {
		int j = 0;
		
		List <WebElement> productos = driver.findElements(By.cssSelector("h4.product-name"));
		
		for (int i = 0; i < productos.size(); i++) {
			
			String[] itemName = productos.get(i).getText().split("-");
			String properItem = itemName[0].trim();
			
			List listName = Arrays.asList(items);
			

			if (listName.contains(properItem)) {
				
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if (j == items.length) {
					break;
				}
			}
			
		}
		driver.quit();
	}
}
