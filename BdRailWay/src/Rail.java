import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Rail {
    public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();

        driver.get("https://eticket.railway.gov.bd/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Agreement
        driver.findElement(By.xpath("//body[1]/div[1]/div[9]/div[1]/div[2]/div[2]/button[1]")).click();

        // From Station
        WebElement fromStation = driver.findElement(By.xpath("//input[@id='dest_from']"));
        fromStation.sendKeys("dh");

        List<WebElement> fromStationSuggestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));

        System.out.println("Total suggestions are: " + fromStationSuggestions.size());

        for (WebElement suggestion : fromStationSuggestions) {
            System.out.println("Suggestions are: " + suggestion.getText());
            if (suggestion.getText().equals("Dhaka")) {
                System.out.println("Record found");
                suggestion.click();
                break;
            }
        }

        // To Station
        WebElement toStation = driver.findElement(By.xpath("//input[@id='dest_to']"));
        toStation.sendKeys("B Si");

        List<WebElement> toStationSuggestions = driver.findElements(By.xpath("//ul[@id='ui-id-2']//li[@role='presentation']"));

        System.out.println("Total suggestions are: " + toStationSuggestions.size());

        for (WebElement suggestion : toStationSuggestions) {
            System.out.println("Suggestions are: " + suggestion.getText());
            if (suggestion.getText().equals("B Sirajul Islam")) {
                System.out.println("Record found");
                suggestion.click();
                break;
            }
        }

        // Pick a date from calendar
        WebElement dateField = driver.findElement(By.xpath("//input[@id='doj']"));
        dateField.click();

        WebElement date1 = driver.findElement(By.xpath("//a[normalize-space()='18']"));
        date1.click();

        // Select Class
        Select selectClass = new Select(driver.findElement(By.xpath("//select[@id='choose_class']")));
        selectClass.selectByIndex(0);
        selectClass.selectByVisibleText("AC_S");

        // Click on Search Button
        driver.findElement(By.xpath("//button[normalize-space()='Search Trains']")).click();
        
        
        
//        Scrol//
        for (int i = 0; i < 5; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Scroll down the page by 50 pixels
            js.executeScript("window.scrollBy(0, 50);");
            // Wait for a short time to let the page load
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        driver.quit();
    }
}
