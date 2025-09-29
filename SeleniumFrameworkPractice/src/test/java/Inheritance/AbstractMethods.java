package Inheritance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AbstractMethods {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public AbstractMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void waitElementVisibility(By FindBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitElementInvisibility(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitElementInvisibility(By FindBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
	}
	
	
	
	public void verifyItemMatch(List<WebElement> list, String productName) {
		
		Boolean match = list.stream().anyMatch(products2 -> 
		 products2.getText().equals(productName));
		
		Assert.assertTrue(match);
	}

	
	
	

}
