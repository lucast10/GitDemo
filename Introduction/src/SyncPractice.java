import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncPractice {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		Map<String, Object> profile = new HashMap<String, Object>();
		profile.put("password_manager_leak_detection", false);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String user = driver.findElement(By.xpath("//p[contains(@class,'text-center')]/b/i")).getText();
		String password = driver.findElement(By.cssSelector("p[class*='text-center'] b:nth-child(2)")).getText();
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		//driver.switchTo().alert().accept();
		
		
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(2);
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-info')]")));
		
		List <WebElement> cartsButtons = driver.findElements(By.xpath("//button[contains(@class, 'btn-info')]"));
		
				
		for (int i = 0; i < cartsButtons.size(); i++) {
			
			cartsButtons.get(i).click();			
			
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class*='btn-primary'")));
		driver.findElement(By.cssSelector("a[class*='btn-primary'")).click();
		System.out.println(driver.findElement(By.cssSelector("button[class*='btn-success']")).getText());
	}

}
