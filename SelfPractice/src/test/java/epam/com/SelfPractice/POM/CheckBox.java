package epam.com.SelfPractice.POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import epam.com.SelfPractice.AllWebDrivers;

public class CheckBox {

	WebDriver driver;
	
	@Test
	public void set() throws InterruptedException {
		
		driver=AllWebDrivers.getWebDriver("Chrome");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]")).click();
//		WebElement ele=driver.findElement(By.xpath("//a[@href=\"/checkboxes\" ]"));
		WebElement ele= driver.findElement(By.linkText("Checkboxes"));
		ele.click();
	}
}
