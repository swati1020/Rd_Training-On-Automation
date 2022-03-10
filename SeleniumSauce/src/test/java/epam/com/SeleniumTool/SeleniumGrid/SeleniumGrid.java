package epam.com.SeleniumTool.SeleniumGrid;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SeleniumGrid {
	WebDriver driver;
	String nodeUrl;
	
	
	public class TestOrangeHRMLoginPage {
		@BeforeClass
		public void setup() throws MalformedURLException {

		driver = WebDriverFactory.getWebDriver("Chrome");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		}
		
		@Test
		public void creatingdriver() throws MalformedURLException{
			nodeUrl="http://192.168.0.107:4444/wd/hub";
			DesiredCapabilities capablities=new DesiredCapabilities();
//			capablities.setBrowserName("chrome");
			driver = new RemoteWebDriver(new URL(nodeUrl), capablities);
			capablities.setPlatform(Platform.WIN10);
			System.out.print(driver.getCurrentUrl());
//			Thread.sleep(5000);
//			driver.close();
		}
		}
	@Test
	public void testLogin() throws InterruptedException {

//	LoginPageEntry loginPage = new LoginPageEntry(driver);
//	loginPage.enterUsername("Admin")
//	.enterPassword("U@qBLVtm09")
//	.loginButton();
	}
}

