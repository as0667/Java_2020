package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
	
	
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suit started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println((" Test Suite  ended"));
		extent.flush();
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(( result.getMethod().getMethodName() + " started"));
		ExtentManager.extLogger =extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		test.set(ExtentManager.extLogger);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println (result.getMethod().getMethodName() + " test successfully passed");
		test.get().pass("Test passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " failed...");
		test.get().fail("failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println( result.getMethod().getMethodName() + " skipped...");
		test.get().skip(result.getThrowable());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
