package epam.com.POM_Assignment;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOrangeHRMLoginPage {
	
	WebDriver driver;

	@BeforeClass

	public void setup(ITestContext context) {
		driver = WebDriverFactory.getWebDriver("Chrome");
		context.setAttribute("WebDriver", driver);

	}

	@Test
	public void loginInUrl()throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		AdminLoginPage loginPage = new AdminLoginPage(driver);
		loginPage.enterUsername("Admin")
		.enterPassword("U@qBLVtm09")
		.loginButton()
		.adminClick()
		.userManagementClick()
		.clickOnusersLeft()
		.editOnUsersPage()
		.clickondropdown()
		.globalAdminOnUsersPage()
		.clickonSaveButton();
		}

}

