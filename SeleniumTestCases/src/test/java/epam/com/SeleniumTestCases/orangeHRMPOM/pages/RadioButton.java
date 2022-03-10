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

public class RadioButton {

	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setup(String Browser) {
		driver = UiAutomationFactoryAssignment2.factory(Browser);

	}
	@Test
	public void radioButton() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/client/#/pim/employees/13/personal_details");
		LoginPage loginPage = new LoginPage(driver);
		loginPage
		.enterUserName("Admin")
		.enterPassword("U@qBLVtm09")
		.clickButton();
	       driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//ul[@class='radiobutton-container']/li[1]/label")));
		WebElement radio = driver.findElement(By.xpath("//ul[@class='radiobutton-container']/li[2]/label"));
		radio.click();

		driver.findElement(By.xpath("//label[@for=\"26Dairy-Free\"]")).click();
		driver.findElement(By.xpath("//label[@for=\"26Gluten-Free\"]")).click();

	}
}