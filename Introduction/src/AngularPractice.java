import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AngularPractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Lucho");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("a@a.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("pass");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select selector = new Select(staticDropdown);
		selector.selectByIndex(0);
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("11/14/1986");
		
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]")).getText());
		
		
				
		driver.quit();
	}                        

}
