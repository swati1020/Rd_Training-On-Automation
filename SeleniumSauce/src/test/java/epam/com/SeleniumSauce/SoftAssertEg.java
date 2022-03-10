package epam.com.SeleniumSauce;
	
import java.net.MalformedURLException;
import java.net.URL;



import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epam.com.SeleniumTool.SeleniumGrid.LoginPageEntry;
import epam.com.SeleniumTool.SeleniumGrid.WebDriverFactory;





public class SoftAssertEg {
WebDriver driver;



private ExtentTest test;
private ExtentReports report;



@BeforeClass
public void setup() throws MalformedURLException {

//String filePath = ".//src/main/resources//ExtentReportResults.html";
//report = new ExtentReports(filePath);
//test = report.startTest("ExtentDemo");

driver = WebDriverFactory.getWebDriver("Chrome");
driver.get("https://prasoonr-trials73.orangehrmlive.com/");
driver.manage().window().maximize();
}
@Test
public void testLogin() throws InterruptedException {
SoftAssert softAssert = new SoftAssert();
LoginPageEntry loginPage = new LoginPageEntry(driver);
loginPage.enterUsername("Admin")
.enterPassword("U@qBLVtm09")
.loginButton();

softAssert.assertTrue(false, "SOFTAssert Fails...continue");
softAssert.assertEquals(driver.getTitle(), "OrangeHRM", "SOFTAssert Fails...continue");
System.out.println("After test case failure");
softAssert.assertAll();
}

@AfterMethod
public void writeTestLog(ITestResult result) {
if(result.isSuccess()) {
test.log(LogStatus.PASS,"test-passed"+result.getTestName());
}
else {
test.log(LogStatus.FAIL,"Test Failed");
}
}



@AfterClass
public void close()
{
driver.close();
driver.quit();
}
}