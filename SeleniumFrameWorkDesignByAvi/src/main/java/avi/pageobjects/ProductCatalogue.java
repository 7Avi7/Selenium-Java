package avi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import avi.AbstractComponents.AbstractComponent;



public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
//		Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3") ;
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = null;
		for (WebElement product : getProductList()) {
		    WebElement bElement = product.findElement(By.cssSelector("b"));
		    if (bElement.getText().equals(productName)) {
		        prod = product;
		        break;
		    }
		}

		if (prod != null) {
		    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart);
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}

	
	
	
}
