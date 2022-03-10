package epam.com.SeleniumTool.SeleniumGrid;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
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

public class LoginPageEntry {
	private final WebDriver driver;
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

	public LoginPageEntry(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public LoginPageEntry enterUsername(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}

	public LoginPageEntry enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

	public LoginPageEntry loginButton() {
		this.loginButton.click();
//this.form.submit();
		return this;
	}
}
