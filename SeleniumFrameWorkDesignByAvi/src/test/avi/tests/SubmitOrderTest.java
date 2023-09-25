package avi.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import avi.TestComponents.BaseTest;
import avi.pageobjects.CartPage;
import avi.pageobjects.CheckoutPage;
import avi.pageobjects.ConfirmationPage;
import avi.pageobjects.OrderPage;
import avi.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	
	String productName = "ZARA COAT 3";
    
	@Test(dataProvider="getData", groups="Purchase")
    public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
        

//        LandingPage landingPage = lunchApplication();

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmationMessage = confirmationPage.getConfirmationMessage();

        Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

        
    }
    
    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest()
    {
    	 ProductCatalogue productCatalogue = landingPage.loginApplication("avisqa7@gmail.com", "Avi@2001");
    	 OrderPage orderPage = productCatalogue.goToOrdersPage();
    	 Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));;
    }
    
    
    
    
    @DataProvider
    public Object[][] getData() throws IOException
    {
    	List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
    	
    	return new Object[][] { { data.get(0) } , { data.get(1) } };
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
