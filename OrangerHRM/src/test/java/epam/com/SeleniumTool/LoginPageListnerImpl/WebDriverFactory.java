package epam.com.SeleniumTool.LoginPageListnerImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	static WebDriver driver;

	public static WebDriver getWebDriver(String browserName) {
		if (browserName.equals("Firefox")) {
			String driverPath = "C:\\Users\\Swati_Deshwal\\Documents\\Browsers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			String driverPath = "C:\\Users\\Swati_Deshwal\\Documents\\Browsers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else {
			driver = null;
		}
		return driver;
	}
}
