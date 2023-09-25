package avi.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import avi.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public LandingPage landingPage;
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\avi\\resources\\GlobalData.properties");

		prop.load(fls);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("firefox")) {

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
//		Read Jason to String 
		String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
				StandardCharsets.UTF_8);
		
//		A string to hash map Jackson data bind 
		
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
		
		return data;
		
		
		
		
		
	}
	
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
    {
		try {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	        FileUtils.copyFile(source, destination);
	        System.out.println("Screenshot taken: " + testCaseName);
	        return destination.getAbsolutePath();
	    } catch (IOException e) {
	        System.err.println("Failed to capture screenshot: " + e.getMessage());
	        return null; // Handle the error as needed
	    }
//    	TakesScreenshot ts = (TakesScreenshot) driver;
//    	File sourse = ts.getScreenshotAs(OutputType.FILE);
//    	File file = new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
//    	FileUtils.copyFile(sourse, sourse);
//    	return System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
    }
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage lunchApplication() throws IOException
	{
		driver = initializeDriver();
		landingPage	= new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
	
}
