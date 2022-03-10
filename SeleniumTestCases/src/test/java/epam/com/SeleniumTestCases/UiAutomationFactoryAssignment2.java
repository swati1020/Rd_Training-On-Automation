package epam.com.SeleniumTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UiAutomationFactoryAssignment2 {
	public static String driver ="chrome";
	public static WebDriver firefox; 
	public static WebDriver edgedriver;
	public static WebDriver drivers;

//	@BeforeClass
//	@Test
	public static WebDriver factory(String driver) {
		if (driver.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			drivers = new FirefoxDriver();

		} else if (driver.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			drivers = new ChromeDriver();
		} else if (driver.equals("edgedriver")) {
			WebDriverManager.edgedriver().setup();
			drivers = new EdgeDriver();
		} else {
			driver = null;
		}

		return drivers;

	}

}
