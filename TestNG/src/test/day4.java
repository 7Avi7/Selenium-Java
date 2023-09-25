package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	@Parameters({"URL","APIKeys/username"})
	@Test
	public void WebloginHomeLoan(String urlname,String key)
	{
//		Selenium
		System.out.println("Selenium Home Login");
		System.out.println(urlname);
		System.out.println(key);
	}
	
	
	@Test(groups={"Smoke"})
	public void MobileloginHomeLoan()
	{
//		Appium
		System.out.println("Appium Home Login");
	}
	
	@Test
	public void LoginAPIHomeLoan()
	{
//		Rest API
		System.out.println("Rest API Home Login");
	}

}
