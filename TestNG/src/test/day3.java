package test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class day3 {
	@BeforeClass
	public void BeforeClass()
	{
//		Appium
		System.out.println("I'm no 1 from day3 BeforeClass");
	}
	@AfterClass
	public void AfterClass()
	{
//		Appium
		System.out.println("I'm no 1 from day3 AfterClass");
	}
	@Parameters({"URL","APIKeys/username"})
	@Test
	public void WebloginCarLoan(String urlname, String key)
	{
//		Selenium
		System.out.println("Selenium Car Login from Weblogin");
		System.out.println(urlname);
		System.out.println(key);
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
//		Appium
		System.out.println("I'm no 1 from day3 beforeMethod");
	}
	@AfterMethod
	public void AfterMethod()
	{
//		Appium
		System.out.println("I'm no 1 from day3 afterMethod");
	}
	@Test(enabled=false)
	public void MobilelogincarLoan()
	{
//		Appium
		System.out.println("Mobile LoginCar");
	}
	
	@BeforeSuite
	public void BfSuite()
	{
//		Appium
		System.out.println("I'm no 1 from day3 BeforeSuite");
	}
	@Test(dataProvider = "getData")
	public void MobilesignoutcarLoan(String username,String password)
	{
//		Appium
		System.out.println("Mobile Sign Out");
		System.out.println(username);
		System.out.println(password);
		
	}
	
	
	@Test(dependsOnMethods = {"WebloginCarLoan","MobilesignoutcarLoan"})
	public void LoginAPIcarLoan()
	{
//		Rest API
		System.out.println("Rest API Car Login");
	}
	
	@DataProvider
	public Object[][] getData() 
	{
//		1st combination - username password - good credit history = row
//		Second username password - no credit history 
//		3rd - fraudelent credit history 
		
		Object[][] data = new Object[3][2];
		data[0][0] = "firstSetUsername";
		data[0][1] = "firstPassword";
//		Columns in the rule are nothing but values for that particular combination(row)
		
		
//		2nd set
		
		data[1][0] = "secondSetUsername";
		data[1][1] = "secondPassword";
		
//		3rd set
		
		data[2][0] = "thirdSetUsername";
		data[2][1] = "thirdPassword";
		
		
		return data;
		
		
		
	}

}
