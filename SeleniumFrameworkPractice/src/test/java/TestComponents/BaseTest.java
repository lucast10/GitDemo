package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pom.LoginPage;

public class BaseTest {
	
	public static WebDriver driver;
	public LoginPage loginPage;
	
	public WebDriver initializeDriver( ) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.contentEquals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.contentEquals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.contentEquals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString
				(new File(filePath),
				StandardCharsets.UTF_8);
		
		//String to HashMap- Jackson Datbind

		  ObjectMapper mapper = new ObjectMapper();

		  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {

		      });

		  return data;


		//{map, map}
	}
	
	@BeforeMethod
	public LoginPage launchApplication() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
	}
	
	@AfterMethod
	public void driverClose( ) {
		driver.quit();
	}
}
