package UiUsingSelenium.DriverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebGridDriverFactory extends DriverFactory {

	private static final String hubURL = "http://localhost:4444/wd/hub";

	public RemoteWebDriver getWebDriver(String BrowserName) throws MalformedURLException {
		RemoteWebDriver driver = null;

		DesiredCapabilities capabilties = new DesiredCapabilities();
		capabilties.setPlatform(Platform.WIN10);

		if (BrowserName.equalsIgnoreCase("firefox")) {
			capabilties.setBrowserName("firefox");
			driver = new RemoteWebDriver((new URL(hubURL)), capabilties);
		} else if (BrowserName.equalsIgnoreCase("chrome")) {

			capabilties.setBrowserName("chrome");
			driver = new RemoteWebDriver((new URL(hubURL)), capabilties);
		} else {
			driver = null;
		}
		return driver;

	}
}
