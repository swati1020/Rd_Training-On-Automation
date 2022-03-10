package epam.com.SeleniumTool.LoginPageListnerImpl;

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

public class TestLoginForListeners {
	WebDriver driver;

	@BeforeClass

	public void setup(ITestContext context) {
		driver = WebDriverFactory.getWebDriver("Chrome");
		context.setAttribute("WebDriver", driver);

	}

	@Test
	public void testfailure() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test
	public void testLogin1() {
		assertTrue(true);
	}
}