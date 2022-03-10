package OrangeHRM;

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
//import epam.com.OrangerHRM.DriverFactory.WebDriverFactoryProvider;
//import epam.com.OrangerHRM.Pages.OrangeHRMPages;

public class LoginPage {
	private WebDriver driver;
	private String orangeHRMUserName;
	private String orangeHRMPassword;
	private String platformname;

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
		OrangeHRMPage login = new OrangeHRMPage(driver);
		login.enterUsername(this.orangeHRMUserName).enterPassword(this.orangeHRMPassword).loginButton();

		assertTrue(true);
	}

	@Test
	public void testLoginWithProxy() {
		OrangeHRMPage loginPage = new OrangeHRMPage(driver);

		loginPage.enterUsernameWithFindElementId(this.orangeHRMUserName).enterPassword(this.orangeHRMPassword)
				.loginButton().logout();

	}

	@Test
	public void testLoginWithProxyJavascript() {
		OrangeHRMPage loginPage = new OrangeHRMPage(driver);

		loginPage.enterUsernameWithFindElementId(this.orangeHRMUserName).enterPassword(this.orangeHRMPassword)
				.clickLoginButtonUsingJavascript().logout();

	}

	// only for sauce lab webdriver
	@AfterMethod
	public void setStatus(ITestResult result) {

		if (platformname.equalsIgnoreCase("SauceWebDriver")) {
			String resultFortest = result.isSuccess() ? "passed" : "failed";
			((RemoteWebDriver) driver).executeScript("sauce:job-result=" + resultFortest);
		}

	}

	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
	}

	public Object enterUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
