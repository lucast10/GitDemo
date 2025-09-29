package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Inheritance.AbstractMethods;

public class LoginPage extends AbstractMethods {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id="userEmail") WebElement userEmail;
	
	@FindBy(id="userPassword") WebElement userPassword;
	
	@FindBy(id="login") WebElement login;
	
	public void loginAs(String email, String password) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
}
