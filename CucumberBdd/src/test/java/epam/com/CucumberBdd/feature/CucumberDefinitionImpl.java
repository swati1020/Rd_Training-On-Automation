package epam.com.CucumberBdd.feature;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
//
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import OrangeHRM.OrangeHRMPage;
import OrangeHRM.WebDriverFactoryProvider;
import io.cucumber.java.en.*;


public class CucumberDefinitionImpl {
	private static WebDriver driver;
	private static String platformname;
	private static String orangeHRMURL;
	private OrangeHRMPage loginPage;

	@Given("Browser")
	public void browser() {
		driver.get(orangeHRMURL);
		loginPage = new OrangeHRMPage(driver);
	}

	@BeforeTest
	public static void setup(ITestContext context) throws MalformedURLException {
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformname = context.getCurrentXmlTest().getParameter("orangeHRMTestExecutionPlatform");
		orangeHRMURL = context.getCurrentXmlTest().getParameter("orangeHRMBaseURL");
		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		driver.get(orangeHRMURL);
//		loginPage = new OrangeHRMPage(driver);

	}
	@Given("Username is {string} and password is {string}")
	public void username_is_and_password_is(String userName, String password) {
		loginPage = loginPage.enterUsername(userName)
				.enterPassword(password);
	}
	@Given("LoginPage is Opened")
	public void login_page_opened()
	{
	driver.get("https://prasoonr-trials73.orangehrmlive.com/auth/login");
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.loginButton();
	}

	@Then("User should navigate to {string}")
	public void user_should_navigate_to(String string) {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("retryLogin"));
	}
	@Then("User should navigate to Dashboard")
	public void user_should_navigate_to_dashboard() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
