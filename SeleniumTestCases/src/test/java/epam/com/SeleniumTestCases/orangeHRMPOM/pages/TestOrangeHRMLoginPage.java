package epam.com.SeleniumTestCases.orangeHRMPOM.pages;

import org.testng.annotations.Test;

import epam.com.SeleniumTestCases.UiAutomationFactoryAssignment2;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestOrangeHRMLoginPage {

	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setup(String Browser) {
		driver = UiAutomationFactoryAssignment2.factory(Browser);

	}

	@Test
//	public void testLoginFunctionality() {
//		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.enterUserName("Admin").enterPassword("U@qBLVtm09")
////		.clickButton();
//				.printElementInput();
//		driver.quit();
//	}
	

	public void actionClass() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//		ActionClass2Eg loginPage = new ActionClass2Eg(driver);
		ActionClass2Eg loginPage = new ActionClass2Eg(driver);
		loginPage.enterUserName("Admin").enterPassword("U@qBLVtm09")
		.clickButton();
		
//		.navigateToLeaveList();
	
//		driver.quit();
	}
//	public Dashboard functionals() {
//		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//		LoginPage loginpage= new LoginPage(driver);
//		loginpage.enterUserName("Admin").enterPassword("U@qBLVtm09")
//		.clickButton();
		
		
		
//		.navigateToLeaveList();
	
//		driver.quit();
	}
	
//	public void jsClass() {
//		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//		jsEg loginPage = new jsEg(driver);
//		loginPage.enterUserName("Admin").enterPassword("U@qBLVtm09")
//		.clickButton();
//				
////		driver.quit();
//	}



