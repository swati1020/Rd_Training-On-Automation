package epam.com.SelfPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Database {

	 public WebDriver driver;
	 
	  public void setup() {
		String driverPath = "C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		 driver = new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("U@qBLVtm09");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		
	}
	public void data1() {
		FirefoxDriver driver = new FirefoxDriver();
//		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	}
	public void data2() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	}
	public void data3() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	}
}
