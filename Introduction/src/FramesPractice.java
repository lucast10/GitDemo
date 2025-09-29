import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesPractice {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		driver.switchTo().frame("frame-top");
		
		driver.switchTo().frame("frame-middle");
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();
		driver.quit();
		
	}
}
