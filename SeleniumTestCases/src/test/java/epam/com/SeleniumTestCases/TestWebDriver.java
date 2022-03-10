package epam.com.SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestWebDriver {

	@Test

	public void LoadWebDriver() {
		String driverPath = "C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
	}

	@Test
	public void LoadWebChromeDriver() {
//String driverPathChrome = "";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
	}
}
