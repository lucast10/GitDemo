import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsTablePractice {
	
	public static void main (String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("th[aria-label='Veg/fruit name: activate to sort column ascending']")).click();
		
		List<WebElement> items = driver.findElements(By.cssSelector("tbody td:nth-child(1)"));
		
		List<String> originalList = items.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> prices;
		do {
		
		List<WebElement> itemsPrices = driver.findElements(By.xpath("//tr/td[1]"));
		
		//List<String> listPrices = itemsPrices.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		prices = itemsPrices.stream().filter(s->s.getText().contains("Mango")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
				
		prices.forEach(a->System.out.println(a));
		
			if (prices.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
		} while (prices.size() < 1);
			
		driver.quit();
		
	}

	private static String getPriceVeggie(WebElement s) {
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
