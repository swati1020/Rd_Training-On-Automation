package epam.com.SelfPractice;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{
	
	public void onTestStart(ITestResult tr) {
		System.out.println("started");
	}
	
	public void onTestSuccess(ITestResult r) {
		System.out.println("success");
	}
	
	public void onTestFailure(ITestResult tar) {
		System.out.println("test failed");
	}
	

}
