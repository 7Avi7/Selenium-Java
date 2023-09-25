import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("");
//		driver.findElement(By(""));
		
		driver.get("https://www.google.com/");
		
		Actions a = new Actions(driver);
		WebElement move=driver.findElement(By.linkText("Images"));
		
		
		
		a.moveToElement(move).build().perform();
		

	}

}
