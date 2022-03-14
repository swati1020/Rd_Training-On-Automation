package UiUsingSelenium.DriverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverWebSAUCEFactory extends DriverFactory {
	private static final String hubURL = "http://localhost:4444/wd/hub";

	public RemoteWebDriver getWebDriver(String browserName) throws MalformedURLException {

		RemoteWebDriver driver = null;

// setting up SAUCE properties/credenials
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "oauth-deshwalswati3-4e7e6");
//sauceOptions.setCapability("password", "oauth-prasoon.rana-5c24c"); // in case of password as credentials
		sauceOptions.setCapability("accessKey", "783b1f38-a5ed-4ac2-aed5-edcb5cc8ad36");
		sauceOptions.setCapability("browserVersion", "latest");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL(
				"https://oauth-deshwalswati3-4e7e6:783b1f38-a5ed-4ac2-aed5-edcb5cc8ad36@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options1 = new ChromeOptions();
			options1.setCapability("sauce:options", sauceOptions);
			driver = new RemoteWebDriver(url, options1);

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options1 = new FirefoxOptions();
			options1.setCapability("sauce:options", sauceOptions);
			driver = new RemoteWebDriver(url, options1);
		} else {
			driver = null;
		}
		return driver;
	}
}
