import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LimitingScopePractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		footer.findElements(By.tagName("a")).size();
		
		WebElement footerLeftSection = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		int linksNumber  = footerLeftSection.findElements(By.tagName("a")).size();
		
		for (int i = 1; i < linksNumber; i++) {
			
			//driver.findElements(By.xpath("//tbody/tr/td[1]/ul[1]/li/a")).get(i).click();
			
			String keyboardTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			footerLeftSection.findElements(By.tagName("a")).get(i).sendKeys(keyboardTab);
			Thread.sleep(2000);
		}
		
			
			Set<String> tabs = driver.getWindowHandles();
			Iterator<String> it = tabs.iterator();
			
			
			
			/*for (int j = 1; j < linksNumber; j++) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}*/
			
			/*while (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				driver.navigate().back();
			}*/
			
			String parent = driver.getWindowHandle();
			 
			for (String handle : driver.getWindowHandles()) {
			    if (!handle.equals(parent)) {
			        driver.switchTo().window(handle);
			        System.out.println(driver.getTitle());
			        driver.close(); // optional: clean up
			    }
			}
			 
			driver.switchTo().window(parent);
	}
}
