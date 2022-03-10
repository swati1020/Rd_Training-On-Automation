package OrangeHRM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory extends DriverFactory {

	 WebDriver driver;

	public WebDriver getWebDriver(String BrowserName) {
//		WebDriver driver = null; 
		if (BrowserName.equalsIgnoreCase("firefox")) {
			String driverPath = "C:\\Users\\Swati_Deshwal\\Documents\\Browsers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);

			driver = new FirefoxDriver();

		} else if (BrowserName.equalsIgnoreCase("chrome")) {
			String driverPath = "C:\\Users\\Swati_Deshwal\\Documents\\Browsers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();

		} else {
			driver = null;

		}

		return driver;
	}

}

