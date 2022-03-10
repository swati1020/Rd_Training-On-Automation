package epam.com.SelfPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WindowHandles {
	
	WebDriver driver;
	@Test
	public void setup() throws InterruptedException {
		driver=AllWebDrivers.getWebDriver("Chrome");
//		driver.get("https://www.saucedemo.com/");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.getWindowHandle();
//		driver.switchTo();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.id("user-dropdown")).click();
//		driver.findElement(By.id("logoutLink")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id=\"logoutLink\"]")).click();
		driver.quit();
	}

}
