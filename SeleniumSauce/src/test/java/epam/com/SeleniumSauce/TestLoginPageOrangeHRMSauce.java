package epam.com.SeleniumSauce;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPageOrangeHRMSauce {

	private final WebDriver driver;

	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	

	public TestLoginPageOrangeHRMSauce(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this);
	}

	public TestLoginPageOrangeHRMSauce enterUserName(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}

	public TestLoginPageOrangeHRMSauce enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

	public TestLoginPageOrangeHRMSauce clickButton() {
		this.loginButton.click();
		return this;
	}

	public void loginButton() {
		// TODO Auto-generated method stub
		
	}
	



	 }



