package epam.com.SeleniumTestCases.orangeHRMPOM.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import epam.com.SeleniumTestCases.UiAutomationFactoryAssignment2;

public class TestOrangeDashboardAndLeaveList {

	WebDriver driver;

	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) {
		driver = UiAutomationFactoryAssignment2.factory(browserName);
	}

	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUserName("Admin").enterPassword("U@qBLVtm09").clickButton().navigateToLeaveList().configure();

		Set<String> windows = driver.getWindowHandles();
		for (Iterator iterator = windows.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("-->" + string);
		}

	}

}
