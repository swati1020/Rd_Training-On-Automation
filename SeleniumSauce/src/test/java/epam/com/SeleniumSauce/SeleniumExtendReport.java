
package epam.com.SeleniumSauce;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

import epam.com.SeleniumTool.SeleniumGrid.LoginPageEntry;
import epam.com.SeleniumTool.SeleniumGrid.WebDriverFactory;

public class SeleniumExtendReport {
	WebDriver driver;

	private ExtentTest test;
	private ExtentReports report;

	@BeforeClass
	public void setup() throws MalformedURLException {

		String filePath = ".//src/main/resources//ExtentReportResults.html";
		report = new ExtentReports(filePath);
		test = report.startTest("ExtentDemo");

		driver = WebDriverFactory.getWebDriver("Chrome");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testLogin() throws InterruptedException {

		LoginPageEntry loginPage = new LoginPageEntry(driver);
		loginPage.enterUsername("Admin").enterPassword("U@qBLVtm09").loginButton();

		if (driver.getTitle().equals("Dashboard")) {
			test.log(LogStatus.PASS, "Naviagted to specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test failed");
		}
	}

	@AfterMethod
 
	public void writetestLog(ITestResult result) throws Exception {
		if (result.isSuccess()) {
			String screenshotPath = getScreenShot(driver, result.getName());
			test.log(LogStatus.PASS, "test passed" + result.getTestName(), test.addScreenCapture(screenshotPath));
		} else {
			String screenshotPath = getScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
	}

	
	public String getScreenShot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String fileName = screenshotName + dateName + ".png";
		String destination = ".//src/main/resources//" + screenshotName + dateName + ".png";
		java.io.File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return fileName;
	}

// public void afterMethod(ITestResult result)
// {
// String resultFortest = result.isSuccess() ? "passed":"failed";
// driver.executeScript("sauce:job-result="+ resultFortest);
// }

	@AfterClass
	public void close() {
//driver.close();
//driver.quit();

		report.endTest(test);
		report.flush();
	}
}