import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitPractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String user = driver.findElement(By.xpath("//p[contains(@class,'text-center')]/b/i")).getText();
		String password = driver.findElement(By.cssSelector("p[class*='text-center'] b:nth-child(2)")).getText();
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		//driver.switchTo().alert().accept();
		
		
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(2);
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.xpath("//button[contains(@class, 'btn-info')]")).isDisplayed()) {
					return driver.findElement(By.xpath("//button[contains(@class, 'btn-info')]"));
				}
				else {
					return null;
				}
			}

		});
		
		//wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-info')]")));

	}

}
