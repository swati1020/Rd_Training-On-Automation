package epam.com.OrangerHRM.DriverFactory.TestLoginPage;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//
import epam.com.OrangerHRM.DriverFactory.WebDriverFactoryProvider;
import epam.com.OrangerHRM.Pages.OrangeHRMPages;


public class TestLoginPage {
	private WebDriver driver;
	private String orangeHRMUserName;
	private String orangeHRMPassword;
	private String platformname;
//	
//
	@BeforeClass
	public void setup(ITestContext context) throws MalformedURLException {

		String BrowserName = context.getCurrentXmlTest().getParameter("BrowserName");
		String orangeHRMURL = context.getCurrentXmlTest().getParameter("orangeHRMBaseURL");
		 platformname = context.getCurrentXmlTest().getParameter("orangeHRMTestExecutionPlatform");
		this.orangeHRMUserName = context.getCurrentXmlTest().getParameter("orangeHRMUserName");
		this.orangeHRMPassword = context.getCurrentXmlTest().getParameter("orangeHRMPassword");

		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(BrowserName);
	System.out.println(driver);
	driver.get("https://prasoonr-trials73.orangehrmlive.com/");
	}

	@Test
	public void testLoginWithValidCredentail() {
		OrangeHRMPages login = new OrangeHRMPages(driver);
		login.enterUsername(this.orangeHRMUserName).enterPassword(this.orangeHRMPassword).loginButton();

		assertTrue(true);
	}

	@Test
	public void testLoginWithProxy() {
		OrangeHRMPages loginPage = new OrangeHRMPages(driver);

		loginPage.enterUsernameWithFindElementId(this.orangeHRMUserName).enterPassword(this.orangeHRMPassword)
				.loginButton().logout();

	}

	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
	}

}
