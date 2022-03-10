package UiUsingSelenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import UiUsingSelenium.DriverFactory.WebDriverFactoryProvider;
import UiUsingSelenium.pages.AttendanceSheet;
import UiUsingSelenium.pages.Dashboard;
import UiUsingSelenium.pages.LoginPage;
import UiUsingSelenium.pages.PunchInPage;
import UiUsingSelenium.pages.PunchOut;

public class TestLoginPage {
	private WebDriver driver;
	private String orangeHRMUserName;
	private String orangeHRMPassword;
	private String platformname;
	private Dashboard dashboard;
	private PunchInPage punchIn;
	private PunchOut punchOut;
	private AttendanceSheet sheet;
	 ExtentReports report;
	 ExtentTest test;

//	
//
	@BeforeClass
	public void setup(ITestContext context) throws MalformedURLException {

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String BrowserName = context.getCurrentXmlTest().getParameter("BrowserName");
		String orangeHRMURL = context.getCurrentXmlTest().getParameter("orangeHRMBaseURL");
		platformname = context.getCurrentXmlTest().getParameter("orangeHRMTestExecutionPlatform");
		this.orangeHRMUserName = context.getCurrentXmlTest().getParameter("orangeHRMUserName");
		this.orangeHRMPassword = context.getCurrentXmlTest().getParameter("orangeHRMPassword");

		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(BrowserName);
		System.out.println(driver);
		driver.manage().window().maximize();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		sheet= new AttendanceSheet(driver);
		
		  context.setAttribute("WebDriver", driver);
		String filePath = ".//src/main/resource//ExtentReportResults.html";
		 report= new ExtentReports(filePath);
	    test=report.startTest("TestSeleniumOfAttendancesheet");
		
	    context.setAttribute("ExtentTest", test);
	  


	    
	}
	
	@AfterClass
	public void after() {
		
		  report.endTest(test);
		    report.flush();

	}

	@Test(priority=1)
	public void testOrangeHrmPage() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.enterUsername(this.orangeHRMUserName)
				.enterPassword(this.orangeHRMPassword)
				.loginButton();

		     
	}
  @Test(priority=2)
	public void navigatingToAttendanceMenu() throws InterruptedException {
	 Dashboard dashboard = new  Dashboard(driver);
	 dashboard.clickAttendanceMenu()
	    .clickOnPunchinPunchOutMenu();
        
	 }
  
  @Test(priority=3)
	public void testingWithTimeAndDateInPunchInPage() throws InterruptedException {
	  punchIn = new  PunchInPage(driver);
	  punchIn.selectPunchInDateFromPunchInOutPage("Thu, 10 Mar 2022")
		.clickOnPunchInTimeButton("10:00")
		.clickOnPunchInButton();
	  assertNotNull(punchIn);
//      
	 }
  @Test(priority=4)
	public void testingPunchOutWithGivingInvalidTime() throws InterruptedException {
	  punchOut = new  PunchOut(driver);
	  punchOut.selectPunchOutDateFromPunchInOutPage("Thu, 10 Mar 2022")
		.clickOnPunchOutTimeButtonFromPunchInOutPage("07:00")
		.verifyInvalidPunchOutMessage()
		.clickOutButtonError()
		.selectPunchOutDateFromPunchInOutPage("Thu, 10 Mar 2022")
		.clickOnPunchOutTimeButtonFromPunchInOutPage("10:15")
		.clickOnPunchOutButton();
	     assertNotNull(punchOut);
//     
	 }
  @Test(priority=5)
 	public void testingTotalTimeHoursOnAttendanceSheet() throws InterruptedException {
 	  this.sheet.clickOnMyAttendanceSheetButton()
      .checkingTheTotalTimeHours();

 
 	 }
  @Test(priority=6)
	public void testingDeletingMsgOnAttendanceSheet() throws InterruptedException {
          this.sheet.clickOnDateButtonFromMyAttendanceSheet()
   .clickDeleteButtonFromMyAttendanceSheet("10 Mar")
   .clickOnDeleteMessageFromMyAttendanceSheet();
    
	 }
}
