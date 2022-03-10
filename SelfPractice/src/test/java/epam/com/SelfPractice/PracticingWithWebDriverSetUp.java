package epam.com.SelfPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticingWithWebDriverSetUp {
	WebDriver driver;
	@Test
	public void setup() {
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
	   driver.get("https://www.google.co.in/" );
	   System.out.println(driver.getTitle());
	   System.out.println(driver.getCurrentUrl());
	   System.out.println(driver.getWindowHandle());
	 
//https://www.youtube.com/watch?v=uz1JDSFH52E
	
	}
	@BeforeClass
	@Test
	public void browserTest() {
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
	   driver.get("https://prasoonr-trials73.orangehrmlive.com/client/#/dashboard" );
	   System.out.println(driver.getTitle());
	   System.out.println(driver.getCurrentUrl());
	   System.out.println(driver.getWindowHandle());
	   driver.quit();

	
	}
}
//System.setProperty("webdriver.chrome.driver",
//		"C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\chromedriver.exe");
//WebDriver driver = new ChromeDriver();
//driver.get("https://www.orangehrm.com/");