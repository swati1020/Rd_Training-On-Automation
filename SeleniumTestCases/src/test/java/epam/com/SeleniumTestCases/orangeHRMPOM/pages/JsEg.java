
package epam.com.SeleniumTestCases.orangeHRMPOM.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import epam.com.SeleniumTestCases.UiAutomationFactoryAssignment2;

public class JsEg {

	private  WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	@Test
	public void setup(String Browser) {
		driver = UiAutomationFactoryAssignment2.factory(Browser);

	}

	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(className= "input-field")
	private List<WebElement> inputFields;
	
	@FindBy(className= "input-field")
	private List<WebElement> inputFieldsBY;
	
	@FindBys({@FindBy(className= "input-field"),@FindBy(tagName ="td")})
	private List<WebElement> inputFieldsBYS;
	
	@FindAll({@FindBy(className= "input-field"),@FindBy(tagName ="td")})
	private List<WebElement> inputFieldsBYALL;
	
//	@FindBy(className ="form-body")
//	private WebElement form;


	public JsEg(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this);
	}

	public JsEg enterUserName(String userName) {
		String script="document.getElementById('txtUsername').value"+userName;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script);
		String scriptForElement="document.getElementById(''txtUsername)";
		WebElement userNameElement =(WebElement)js.executeScript(scriptForElement);
//		this.userName.sendKeys(userName);
		userNameElement.click();
		return this;
	}

	public JsEg enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

	public JsEg clickButton() {
		Actions actions= new Actions(driver);
		actions.moveToElement(this.loginButton).click().perform();
//		this.loginButton.click();
		return this;
	}
}
	

	





