package avi.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import avi.TestComponents.BaseTest;
import avi.pageobjects.CartPage;
import avi.pageobjects.CheckoutPage;
import avi.pageobjects.ConfirmationPage;
import avi.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest {

	@Test(groups = { "ErrorHandling" })
	public void LoginErrorValidation() throws InterruptedException, IOException {
		String productName = "ZARA COAT 3";

//        LandingPage landingPage = lunchApplication();

		landingPage.loginApplication("avi7@gmail.com", "Av2001");
		Assert.assertEquals("Incorrect Email or Password", landingPage.geterrorMessage());
		;
	}

	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {
		String productName = "ZARA COAT 3";

//        LandingPage landingPage = lunchApplication();

		ProductCatalogue productCatalogue = landingPage.loginApplication("avisqa7@gmail.com", "Avi@2001");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");

		Assert.assertFalse(match);

	}
}

//package avi.tests;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import avi.pageobjects.CartPage;
//import avi.pageobjects.CheckoutPage;
//import avi.pageobjects.ConfirmationPage;
//import avi.pageobjects.LandingPage;
//import avi.pageobjects.ProductCatalogue;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class SubmitOrderTest extends BaseTest{
//
//	public static void main(String[] args) throws InterruptedException, IOException {
//		
//		@Test
//		public void submitOrder() {
//			String productName = "ZARA COAT 3";
//			
//			LandingPage landingPage = lunchApplication();
//			
////			WebDriverManager.chromedriver().setup();
////			WebDriver driver = new ChromeDriver();
////			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////			driver.manage().window().maximize();
////			
////			
////			
////			
////			LandingPage landingPage	= new LandingPage(driver);
////			landingPage.goTo();
//			ProductCatalogue productCatalogue = landingPage.loginApplication("avisqa7@gmail.com", "Avi@2001");
//			
//			
////			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//			List<WebElement> products = productCatalogue.getProductList();
//			productCatalogue.addProductToCart(productName);
//			CartPage cartPage = productCatalogue.goToCartPage();
//			
//			
////			CartPage cartPage = new CartPage(driver);
//			Boolean match = cartPage.VerifyProductDisplay(productName);
//			
//			
//			
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//
//			Assert.assertTrue(match);
//			
//			
//			
//			CheckoutPage checkoutPage = cartPage.goToCheckout();
//			checkoutPage.selectCountry("india");
//			ConfirmationPage confirmationPage = checkoutPage.submitOrder();
//			
//			String confirmationMessage = confirmationPage.getConfirmationMessage();
//
////			
//			
//			Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//			
//			driver.close();
//			
//		}
//	}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//
