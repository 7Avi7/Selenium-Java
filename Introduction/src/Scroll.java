import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Cast the driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by pixels
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(3000);

        // Scroll to a specific element
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        Thread.sleep(3000);

        driver.quit();
    }
}
