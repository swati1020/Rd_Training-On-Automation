package epam.com.SelfPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DropDown {
	WebDriver driver;
	
	@Test
	public void setup() throws InterruptedException {
		
	driver	=AllWebDrivers.getWebDriver("Chrome");
		//why not taking the running
//		WebDriver11 d= new WebDriver11();
//		d.LoadWebChromeDriver();
		driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");
		driver.findElement(By.id("ins-prompt-c8861")).click();
		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Basic']")).click();//onwayTrip 
	}

}
