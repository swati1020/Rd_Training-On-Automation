package epam.com.POM_Assignment;
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

public class AdminLoginPage {
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

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public AdminLoginPage enterUsername(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}

	public AdminLoginPage enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

	public Admin loginButton() {
		this.loginButton.click();
		return new Admin(driver);
	}
}
