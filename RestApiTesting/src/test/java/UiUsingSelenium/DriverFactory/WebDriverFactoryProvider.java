package UiUsingSelenium.DriverFactory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactoryProvider {
//	static WebDriver driver;

	public static DriverFactory getWebDriverFactory(String platformname)throws MalformedURLException {
		DriverFactory factory=null;
		
		if (platformname.equalsIgnoreCase("LocalWebDriver")) {
			System.out.println("Im in LocalWebDriver");
			factory =new WebDriverFactory();
			
			
		} else if (platformname.equalsIgnoreCase("GridWebDriver")) {
			factory =new WebGridDriverFactory();
		
		}else if (platformname.equalsIgnoreCase("SauceWebDriver")) {
			factory =new DriverWebSAUCEFactory();
		}
		return factory;
	}
}
