package epam.com.OrangerHRM.DriverFactory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public abstract class DriverFactory {

	public abstract WebDriver getWebDriver(String BrowserName)throws MalformedURLException;
	
}
