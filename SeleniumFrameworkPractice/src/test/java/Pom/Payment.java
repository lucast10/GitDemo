package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Inheritance.AbstractMethods;

public class Payment extends AbstractMethods {
	
	WebDriver driver;
	
	public Payment(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By selector = By.cssSelector("input[placeholder='Select Country']");
	By country = By.cssSelector(".ta-results button");
	
	@FindBy(css="input[placeholder='Select Country']") WebElement dropdown;
	@FindBy(css=".ta-results button") WebElement countryElement;
	
	public void selectCountry(String countrySelection) {
		waitElementVisibility(selector);
		Actions a = new Actions(driver);
		a.sendKeys(dropdown, countrySelection).build().perform();
		waitElementVisibility(country);
		countryElement.click();
	}
	
	By buttonPlaceBy = By.cssSelector(".action__submit");
	
	@FindBy(css=".action__submit") WebElement buttonPlaceElement;

	String textComparison = "thankyou for the order.";
	
	public void placeOrder() {
		
		waitElementVisibility(buttonPlaceBy);
		waitElementClickable(buttonPlaceElement);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;

		js2.executeScript("arguments[0].click();", buttonPlaceElement);

	}
	
	public String verifyOrder() {
		String texto = driver.findElement(By.cssSelector(".hero-primary")).getText();
		return texto;
	}
	
	
	
}
