import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingPractice {

		public static void main(String[] args ) {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://the-internet.herokuapp.com/");
			
			driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
			
			driver.findElement(By.cssSelector("a[href='/windows/new'")).click();
			
			Set<String> window = driver.getWindowHandles();
			
			Iterator<String> it = window.iterator();
			
			String parentId = it.next();
			String childId = it.next();
			
			driver.switchTo().window(childId);
			System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
			
			driver.switchTo().window(parentId);
			
			System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
			
			driver.quit();
			
		}
	
}
