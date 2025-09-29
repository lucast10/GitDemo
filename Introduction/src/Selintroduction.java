import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Selintroduction {

	public static void main(String[] args) throws InterruptedException {
		
		//CHROME WEBDRIVER
		//System.setProperty("webdriver.chrome.driver", "localpath/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//FIREFOX WEBDRIVER
		//System.setProperty("webdriver.gecko.driver", "localpath/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//EDGE WEBDRIVER
		//System.setProperty("webdriver.edge.driver", "localpath/msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		
		/*
		Locators
		
		CSS selector
		Class name -> tagname.classname
		id -> tagname#id
		attribute -> tagname[attribute='value']
		input[type='text']:nth-child(3) (with index)
		.classname
		parentname childname
		input[type*='pass'] this * will search all type starting with pass
		tagname
		"div[class='login-container] h2" find h2 inside a div
				
		Xpath
		//tagname[@attribute='value']
		 //input[@type='text']
		 //input[@type='text'][2] (with index) 
		 //parent/child[index]
		 //button[@class='submit signInBtn'] with xpath custom entire class is given, with css only one is enough
		//button[contains(@class,'submit')] with xpath that can be dynamic instead of * this can be completed with contains
		//div[@class='forgot-pwd-btn-conainer']/button[1] to search for container button child number 1 out of 2
		//tagname
		 //button[text()="Log Out"] to find any button with logout text
		 //*[text()="Log Out"] to find anything with text logout
		  //header/div/button[1]/following-sibling::button[1] find sibling of button based on index
		  //header/div/button[1]/parent::div/button[2] find parent of button which is div based on type
		   (//a[@value='ARG'])[2] when there are 2 dropdowns and the value is present, you can indicate there's a second options by adding an index
		   //div[@class='product-action']/button traverse to child button of this div
			(//span[@class='checkmark'])[2] second element if there are many of the same
		  */
		
	
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email'")).sendKeys("john@rsa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulsheetyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		driver.close();
	}
}
