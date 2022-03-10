package epam.com.OrangerHRM.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory extends DriverFactory {

//	WebDriver driver = null;

	public WebDriver getWebDriver(String BrowserName) {
		WebDriver driver = null;
		if (BrowserName.equals("firefox")) {
			String driverPath = "C:\\Users\\Swati_Deshwal\\Documents\\Browsers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);

//			driver = new FirefoxDriver();
			driver = new WebDriverProxy(new FirefoxDriver());

		} else if (BrowserName.equals("chrome")) {
			String driverPath = "C:\\Users\\Swati_Deshwal\\Documents\\Browsers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
//			driver = new ChromeDriver();
			System.out.println("After Creating the object..........");
			driver = new WebDriverProxy(new ChromeDriver());
		} else {
			driver = null;

		}

		return driver;
	}

}
