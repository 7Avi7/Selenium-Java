package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestListener;

public class Listeners implements ITestListener{
	@Override
    public void onTestStart(ITestResult result) {
        // This method is called when a test method starts.
        // You can implement actions to perform before a test method starts.
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//    	System.out.println("I successfully executed listeners passcode ");
        // This method is called when a test method is successful.
        // You can implement actions to perform after a test method succeeds.
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("It failed executed listeners Pass code " + result.getName());
        // This method is called when a test method fails.
        // You can implement actions to perform after a test method fails, e.g., take a screenshot.
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // This method is called when a test method is skipped.
        // You can implement actions to perform when a test method is skipped.
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is called when a test method fails within the success percentage defined in the TestNG configuration.
    }

    @Override
    public void onStart(ITestContext context) {
        // This method is called before the execution of all test methods in a test suite.
        // You can implement actions to perform before the test suite starts.
    }

    @Override
    public void onFinish(ITestContext context) {
        // This method is called after the execution of all test methods in a test suite.
        // You can implement actions to perform after the test suite finishes.
    }
}
