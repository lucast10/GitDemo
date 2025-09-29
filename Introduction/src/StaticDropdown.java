import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement StaticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown = new Select(StaticDropdown);
		
		dropdown.selectByIndex(3);
		dropdown.selectByVisibleText("AED");
		dropdown.selectByValue("USD");
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(2000);
		
		String[] numberOfAdults = driver.findElement(By.id("divpaxinfo")).getText().split(" ");
		

		String adult = numberOfAdults[0];
		
		Assert.assertEquals(adult, "5"); 
		
		driver.close();
	}

}
