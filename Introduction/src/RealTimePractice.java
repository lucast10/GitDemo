import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RealTimePractice {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		String checkbox2 = driver.findElement(By.cssSelector("label[for='benz']")).getText().toLowerCase();
		
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select drop = new Select(dropdown);
		
		drop.selectByValue(checkbox2);
		
		driver.findElement(By.id("name")).sendKeys(checkbox2);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String checkAlert = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		String[] textAlert = checkAlert.split(" ");
		
		List<String> texto = Arrays.asList(textAlert);
		
		boolean check = false;
		
		/*for (int i = 0; i < texto.size(); i++) {
			
			String verificar = texto.get(i);
			
			System.out.print(verificarFixed);
			if (verificarFixed == checkbox2) {
				check = true;
			}
		}*/
		
		String verificarFixed = checkbox2.split(",")[0].trim();
		System.out.print(verificarFixed);
		if (verificarFixed == checkbox2) {
			check = true;
		}
		Assert.assertTrue(check);
		
/*         SCROLLING DOWN PAGE THEN TABLE */
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum = 0;
		
		for (int i = 0; i < values.size(); i++) {
			
			sum = sum +	Integer.parseInt(values.get(i).getText());
			
		}
		
		System.out.println(sum);
		String[] result = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
		String correctResult = result[1].trim();
		int sumApp = Integer.parseInt(correctResult);
		Assert.assertEquals(sum, sumApp);

		
		driver.quit();
	}
	
}
