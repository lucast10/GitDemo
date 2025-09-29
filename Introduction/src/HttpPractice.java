

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	
public class HttpPractice {


	public static void main(String[] args) {
	
	ChromeOptions options = new ChromeOptions();

	WebDriver driver = new ChromeDriver(options);
	
	Proxy proxy = new Proxy();

	proxy.setHttpProxy("ipaddress:4444"); //to use proxy

	options.setCapability("proxy", proxy);

	Map<String, Object> prefs = new HashMap<String, Object>();



	prefs.put("download.default_directory", "/directory/path"); //download path



	options.setExperimentalOption("prefs", prefs);

	// FirefoxOptions options1 = new FirefoxOptions();

	// options1.setAcceptInsecureCerts(true);

	// EdgeOptions options2 = new EdgeOptions();

	options.setAcceptInsecureCerts(true);

	System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");



	

	driver.get("https://expired.badssl.com/");

	System.out.println(driver.getTitle());
	
	
	
	
}
}