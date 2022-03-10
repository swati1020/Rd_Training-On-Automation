package epam.com.SelfPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoogleSearch {
	WebDriver driver;
	@Test
	public void setup() throws InterruptedException {
		String path="C:\\Users\\Swati_Deshwal\\Documents\\Browsers.chromedriver.exe";
		System.setProperty("driver","path");
//		  Actions actions = new Actions(driver);
		driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("cricket");
//		driver.findElement(By.xpath("//div[@class=\"pcTkSc\"]")).click();
	
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
//		((WebElement) driver).
//         ((WebElement) driver).submit();
		Thread.sleep(3000);
		driver.quit();
	}

}
