import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class US_Bangla_AirLines_Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://usbair.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		Thread.sleep(1000);
		WebElement dateField = driver.findElement(By.cssSelector("div[class='w-full h-[60px] px-4 flex flex-col justify-center border border-[#D7D7D7] hover:bg-input-bg hover:cursor-pointer bg-input-bg rounded-l lg:rounded-none md:rounded-l sm:rounded-none']"));
        dateField.click();
        Thread.sleep(1000);
        WebElement date1 = driver.findElement(By.xpath("//button[@class='rdrDay rdrDayWeekend rdrDayEndOfWeek rdrDayEndOfMonth']//span[contains(text(),'30')]"));
//        date1.click();
        Thread.sleep(1000);
        
     // Locate the element you want to double-click by its locator (e.g., by ID, XPath, etc.)
        WebElement elementToDoubleClick = date1;

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        // Perform a double-click action on the element
        actions.doubleClick(elementToDoubleClick).perform();
        
        
        
        Thread.sleep(1000);
        WebElement dateField2 = driver.findElement(By.cssSelector("div[class='w-full h-[60px] px-4 flex flex-col justify-center border border-[#D7D7D7] hover:bg-input-bg hover:cursor-pointer bg-input-bg border-l-0 rounded-r md:rounded-r lg:rounded-none']"));
        dateField2.click();
        Thread.sleep(1000);
        WebElement date2 = driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[2]/section[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]/button[3]/span[1]"));
        date2.click();
        Thread.sleep(1000);

	}

}
