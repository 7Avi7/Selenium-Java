package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

	@Test(groups={"Smoke"})
	public void ploan() {
		System.out.println("Hello this is from day2");

	}
	@BeforeTest
	public void prerequiste() {
		System.out.println("Hello this is from prerequiste day2. I will execute First");

	}

}
