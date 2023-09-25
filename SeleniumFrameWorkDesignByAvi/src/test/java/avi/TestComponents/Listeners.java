package avi.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import avi.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());//
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String filePath = null;
		try {
			
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		
		//Screenshot, Attach to report
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	
	
	
	

}

//package avi.TestComponents;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import avi.resources.ExtentReporterNG;
//
//public class Listeners extends BaseTest implements ITestListener {
//	ExtentTest test;
//	ExtentReports extent = ExtentReporterNG.getReportObject();
//
//    @Override
//    public void onTestStart(ITestResult result) {
//    	test = extent.createTest(result.getMethod().getMethodName());
//        // This method will be called when a test method starts.
////        System.out.println("Test Started: " + result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//    	test.log(Status.PASS,"Test Passed");
//        // This method will be called when a test method passes successfully.
////        System.out.println("Test Passed: " + result.getName());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//    	test.fail(result.getThrowable());
//    	
//    	try {
//    		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//    		
//    	} catch(Exception e1) {
//    		e1.printStackTrace();
//    	}
//    	
//    	
//    	
//        // This method will be called when a test method fails.
////    	Screenshot
//    	String filePath = null;
//		try {
//			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
//    	
//    	
////        System.out.println("Test Failed: " + result.getName());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        // This method will be called when a test method is skipped.
////        System.out.println("Test Skipped: " + result.getName());
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        // This method will be called when a test method fails but within success percentage.
//        // You can customize this behavior as needed.
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        // This method will be called before the test suite starts.
////        System.out.println("Test Suite Started: " + context.getName());
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//    	extent.flush();
//        // This method will be called after the test suite finishes.
////        System.out.println("Test Suite Finished: " + context.getName());
//    }
//}
//
