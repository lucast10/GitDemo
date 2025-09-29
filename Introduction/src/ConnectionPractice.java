import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class ConnectionPractice {

	public static void main(String[] args) throws URISyntaxException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		/*String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		URI uri = new URI(url);
		URL safeUrl = uri.toURL(); 
		HttpURLConnection connection = (HttpURLConnection) safeUrl.openConnection();
		
		connection.connect();
		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);*/
		//////////////////////////////////////////////////////////////////////////
		
		List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert soft = new SoftAssert();
		
		for (WebElement link : allLinks) {
			
			String webURL = link.getAttribute("href");
			
			URI ur = new URI(webURL);
			URL safeUrl1 = ur.toURL(); 
			HttpURLConnection connections = (HttpURLConnection) safeUrl1.openConnection();
			
			connections.connect();
			int responseCodes = connections.getResponseCode();
			soft.assertFalse((responseCodes > 400), "Response code error: "+responseCodes+" on link: "+webURL);
		
		}
		soft.assertAll();
	}

}
