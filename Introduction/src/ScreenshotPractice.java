

		import java.io.File;
		import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;



public class ScreenshotPractice {


		
			public static void main(String[] args) throws IOException {
				// TODO Auto-generated method stub

				 


			//	 System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					
				
				//	driver.manage().deleteCookieNamed("sessionKey");
				
				//click on any link
					//login page- verify login url
					
					
					driver.get("http://google.com");
					
					File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src, new File("C:\\Users\\luciano.castellucci\\screenshot.png"));
				
					
					
			}
			

			

	

}
