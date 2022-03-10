package epam.com.SeleniumSauce;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import org.junit.BeforeClass;
//import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//
//public class WebSauceDriverFactory {
//	
//	protected RemoteWebDriver driver;
////	WebDriver driver;
//	@BeforeClass
//	@Parameters("browserName")
//	public void setup() throws MalformedURLException {
//		driver= WebSauceDriverFactory.getWebDriver("chrome");
//
//		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//             driver.manage().window().maximize();
////	}
//		
//             MutableCapabilities sauceOptions = new MutableCapabilities();
//             sauceOptions.setCapability("username", "oauth-deshwalswati3-4e7e6");
//             //sauceOptions.setCapability("password", "oauth-prasoon.rana-5c24c"); // in case of password as credentials
//             sauceOptions.setCapability("accessKey", "783b1f38-a5ed-4ac2-aed5-edcb5cc8ad36");
//             sauceOptions.setCapability("browserVersion", "latest");
//             ChromeOptions options = new ChromeOptions();
//             options.setCapability("sauce:options", sauceOptions);
//
//             URL url = new URL("https://oauth-deshwalswati3-4e7e6:783b1f38-a5ed-4ac2-aed5-edcb5cc8ad36@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//             driver = new RemoteWebDriver(url, options);
//	}
//
//	@Test
//	public void testLogin() throws InterruptedException {
//	driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//	TestLoginPageOrangeHRMSauce loginPage = new TestLoginPageOrangeHRMSauce(driver);
//	loginPage.enterUserName("Admin")
//	.enterPassword("U@qBLVtm09")
//	.clickButton();
//	}
//	@AfterMethod
//	public void afterMethod() {
//		String resultForTest=result.isSuccess() ? "passed": "failed";
//		driver.executeScript("sauce:job.result ="+ resultForTest);
//	}
//	}
	
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebSauceDriverFactory {
WebDriver driver;
private ExtentTest test;
private ExtentReports report;

@BeforeClass
//@Parameters("browserName")
@Test
public void setup() throws MalformedURLException {
// setting up SAUCE properties/credenials
//MutableCapabilities sauceOptions = new MutableCapabilities();
//sauceOptions.setCapability("username", "oauth-deshwalswati3-4e7e6");
////sauceOptions.setCapability("password", "oauth-prasoon.rana-5c24c"); // in case of password as credentials
//sauceOptions.setCapability("accessKey", "783b1f38-a5ed-4ac2-aed5-edcb5cc8ad36");
//sauceOptions.setCapability("browserVersion", "latest");
//ChromeOptions options = new ChromeOptions();
//options.setCapability("sauce:options", sauceOptions);
//URL url = new URL("https://oauth-deshwalswati3-4e7e6:783b1f38-a5ed-4ac2-aed5-edcb5cc8ad36@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//driver = new RemoteWebDriver(url, options);
	
	
	
	//generating report
	String filePath = ".//src/main/resources//ExtentReportResults.html";
	report = new ExtentReports(filePath);
	test = report.startTest("ExtentDemo");
//	driver = .factory("chrome");
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://prasoonr-trials73.orangehrmlive.com/");
	driver.manage().window().maximize();


}



@Test
public void testLogin() throws InterruptedException {
driver.get("https://prasoonr-trials73.orangehrmlive.com/");
TestLoginPageOrangeHRMSauce loginPage = new TestLoginPageOrangeHRMSauce(driver);
loginPage.enterUserName("Admin")
.enterPassword("U@qBLVtm09")
.loginButton();

// for checkinh the status

if(driver.getTitle().equals("OrangeHRM")) {
	test.log(LogStatus.PASS, "navigate to url");
}else {
	test.log(LogStatus.FAIL, "failed");
}
}
//@AfterMethod
//public void afterMethod(ITestResult result)
//{
//String resultFortest = result.isSuccess() ? "passed":"failed";
//driver.executeScript("sauce:job-result="+ resultFortest);
//}

@AfterClass
public void close()
{
driver.close();
driver.quit();

report.endTest(test);
report.flush();
}
}
