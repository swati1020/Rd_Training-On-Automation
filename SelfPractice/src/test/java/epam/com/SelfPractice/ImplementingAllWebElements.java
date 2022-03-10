package epam.com.SelfPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImplementingAllWebElements {
	WebDriver driver;

	@Test(priority=1)
	public void setup() {
//		AllWebDrivers o= new AllWebDrivers();
//		
		System.setProperty("webdriver.chrome", "C:\\Users\\Swati_Deshwal\\Documents\\Browsers\\chromedriver.exe");
////        driver.get("https://www.saucedemo.com/");
//		driver = new ChromeDriver();
		driver = AllWebDrivers.getWebDriver("Chrome");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void credentails() {
//		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        String str=driver.getCurrentUrl();
        String tile=driver.getTitle();
        String page=driver.getPageSource();
        System.out.println(str+" "+ tile+"  "+ page);
        driver.navigate().to("https://www.saucedemo.com/");
	}

}
