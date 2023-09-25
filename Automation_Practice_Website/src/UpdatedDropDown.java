import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		driver.findElement(By.(""));
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		
		
//		System.out.println(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).click();
//		System.out.println(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		
		System.out.println(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size());
		
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
//		While Loop
//		int i = 1;
//		
//		while(i<5) {
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//		}
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//		For Loop
		for(int i = 1; i<5; i++) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) 
		{
			System.out.println("It is Enabled...!!!");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		
		
	}

}
