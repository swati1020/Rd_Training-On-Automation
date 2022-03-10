package epam.com.SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PracticeSiteWithSelenium {
	
	@Test
	void userLogin() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("testing");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

}
