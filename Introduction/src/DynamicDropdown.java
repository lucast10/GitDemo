import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		/*driver.get("https://www.airpaz.com/en");
		driver.findElement(By.id("headlessui-combobox-input-v-0-0-67")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[contains(text(), 'Rome')]")).click();*/
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		/*driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		//driver.findElement(By.xpath("//a[value='MAA'[2]]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).getAttribute("value"));
		
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		
		
		List<WebElement> listOfOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[class='ui-menu-item'] a")));
		
		for(WebElement option: listOfOptions) {
			
			if(option.isDisplayed() && option.getText().equalsIgnoreCase("India")) {
				option.click();
				System.out.println(option.getText());
				break;
			}
		}	
		*/
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		for(int i = 0; i<4; i++) {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("hrefIncAdt")));
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		driver.quit();
		
	}
}
