package epam.com.SelfPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SwitchtoMultipleWindows {

	WebDriver driver;
	@Test
	public void setup() throws InterruptedException {
		driver=AllWebDrivers.getWebDriver("Chrome");
		driver.get("https://www.google.co.in/");
//		driver.findElement(By.name("q")).sendKeys("abcd");
//		Thread.sleep(3000);
//		driver.findElement(By.name("btnK")).click();
	}
	
}
