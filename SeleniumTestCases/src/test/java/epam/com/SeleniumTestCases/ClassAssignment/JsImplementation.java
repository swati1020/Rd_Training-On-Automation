package epam.com.SeleniumTestCases.ClassAssignment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import epam.com.SeleniumTestCases.UiAutomationFactoryAssignment2;

public class JsImplementation {
	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setup(String Browser) {
		driver = UiAutomationFactoryAssignment2.factory(Browser);

	}
}
