import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Links_Count {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Website All Links
        System.out.println(driver.findElements(By.tagName("a")).size());

        // Footers All Links
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // Footer 1st Column
        WebElement columnDriver = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        // Capture the main window handle
//        String mainWindowHandle = driver.getWindowHandle();

        // Click on each link in the column and open in new tabs
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);
        }
        
//        Get All Tab's Title Name
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();
        
        while(it.hasNext())
        {
        	driver.switchTo().window(it.next());
        	System.out.println(driver.getTitle() + driver.getCurrentUrl());
        }
        
        

        // Switch to new tabs and capture URLs
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        for (String tab : tabs) {
//            if (!tab.equals(mainWindowHandle)) {
//                driver.switchTo().window(tab);
//                System.out.println("New Tab URL: " + driver.getCurrentUrl());
//                driver.close();
//            }
//        }

        // Switch back to the main window
//        driver.switchTo().window(mainWindowHandle);
    }
}



//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Links_Count {
//
//	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		
////		Website All Links
//		System.out.println(driver.findElements(By.tagName("a")).size());
//		
//		
////		Footers All Links
//		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
//
//		System.out.println(footerDriver.findElements(By.tagName("a")).size());
//
//		
////		Footer 1st Column
//		
//		WebElement columnDriver = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
//		
//		System.out.println(columnDriver.findElements(By.tagName("a")).size());
//		
////		Click on each link in the column and check if the pages are opening 
//		
//		for(int i = 1; i<columnDriver.findElements(By.tagName("a")).size();i++) 
//		{
//			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
//			
//			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
//			Thread.sleep(5000L);
//		}
//		
//	}
//
//}
