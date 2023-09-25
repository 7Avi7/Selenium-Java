package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class day1 {
	@AfterTest
	public void lastexecution() {
		System.out.println("Hello this is from lastexecution day1. I will execute last");
		

	}
	@Test
	public void Demo() {
		System.out.println("Hello");
		Assert.assertTrue(false);

	}
	
	@AfterSuite
	public void aSuite() {
		System.out.println("I'm the last from day1");

	}
	
	@Test
	public void SecondCase() {
		System.out.println("This is from second case.");

	}

}
