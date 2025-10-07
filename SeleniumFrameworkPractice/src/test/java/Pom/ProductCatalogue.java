package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Inheritance.AbstractMethods;

public class ProductCatalogue extends AbstractMethods {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="#ngx-spinner-overlay") WebElement overlay;
	@FindBy(xpath="//div[contains(@class, 'mb-3')]") List<WebElement> products;
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']") WebElement cartButton;
	@FindBy(xpath=".//div[@class='card-body']/button[2]") WebElement addCart;
	By spinner = By.cssSelector("#ngx-spinner-overlay");
	
	By productsBy = By.xpath("//div[contains(@class, 'mb-3')]");
	
	public List<WebElement> getProductList() {
		waitElementVisibility(productsBy);
		return products;
	}
	
	public WebElement getProduct(String productName) {
		
		WebElement prod = getProductList().stream().filter(product->		
		 product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		
		WebElement prod = getProduct(productName);
		prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		waitElementInvisibility(overlay);
	}
	
	public void goToCart() {
		waitElementInvisibility(spinner);
		waitElementClickable(cartButton);
		cartButton.click();
	}
	
	
}
