package epam.com.SelfPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelSheetByDataProvider {
	WebDriver11 driver;
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
