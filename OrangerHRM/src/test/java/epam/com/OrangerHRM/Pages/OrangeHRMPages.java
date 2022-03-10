package epam.com.OrangerHRM.Pages;
//import java.io.File;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindAll;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBys;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//
//public class OrangeHRMPages {
//	private final WebDriver driver;
//	
//	private Dashboard dashboard;
//	@FindBy(id = "txtUsername")
//	private WebElement userName;
//	
//	@FindBy(id = "txtPassword")
//	private WebElement password;
//	
//	private WebElement userNameWithFind ;
//	@FindBy(className = "input-field")
//	
//	private List<WebElement> inputFields;
//	@FindBys({@FindBy(className = "input-field"),@FindBy(tagName ="td")})
//	private List<WebElement> inputFieldBYS;
//	
//	@FindAll({@FindBy(className = "input-field"),@FindBy(tagName ="td")})
//	private List<WebElement> inputFieldBYALL;
//	
//	@FindBy(xpath = "//button[@type=\"submit\"]")
//	private WebElement loginButton;
//	
//	@FindBy(className= "form-body")
//	private WebElement form;
//
//	public OrangeHRMPages(WebDriver webdriver) {
//		this.driver = webdriver;
//		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
//		PageFactory.initElements(factory, this);
//	}
//
//	public OrangeHRMPages enterUsername(String userName) {
//		this.userName.sendKeys(userName);
//		return this;
//	}
//
//	public OrangeHRMPages enterPassword(String password) {
//		this.password.sendKeys(password);
//		return this;
//	}
//
//	public Dashboard loginButton() {
//		this.loginButton.click();
//        this.form.submit();
//		return new Dashboard(driver);
//	}
//
//}
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OrangeHRMPages {
	private final WebDriver driver;
	private WebElement userNameWithFind;
	@FindBy(id = "txtUsername")
	private WebElement userName;
	@FindBy(id = "txtPassword")
	private WebElement password;
	@FindBy(className = "input-field")
	private List<WebElement> inputFields;
	@FindBy(className = "form-body")
	private WebElement form;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement loginButton;

	public OrangeHRMPages(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public OrangeHRMPages enterUsername(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}

	public OrangeHRMPages enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

	public Dashboard loginButton() {
		this.form.submit();
		return new Dashboard(driver);
	}
	public OrangeHRMPages enterUsernameWithFindElementId(String userName) {
		this.userNameWithFind=driver.findElement(By.id("txtUsername"));
		this.userNameWithFind.sendKeys(userName);
		return this;
		}
	public Dashboard clickLoginButtonUsingJavascript() {
		JavascriptExecutor jsDriver =(JavascriptExecutor)driver;
		jsDriver.executeScript("document.getElementById('txtUsername')");
		this.form.submit();
		return new Dashboard(driver);
		}
}
