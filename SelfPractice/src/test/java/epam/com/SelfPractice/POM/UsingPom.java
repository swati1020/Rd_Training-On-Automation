package epam.com.SelfPractice.POM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import epam.com.SelfPractice.AllWebDrivers;

public class UsingPom {
	WebDriver driver;
//	@Test
	public void set() throws InterruptedException {
		SearchingElemntInChromeByUsingPom obj= new SearchingElemntInChromeByUsingPom ();
		driver= AllWebDrivers.getWebDriver("Chrome");
		driver.get("https://www.google.co.in/");
		Thread.sleep(3000);
		obj.google();
		Thread.sleep(3000);
		obj.search();
	}

}
