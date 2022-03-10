package epam.com.SeleniumTestCases.ClassAssignment;


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

import epam.com.SeleniumTestCases.orangeHRMPOM.pages.Dashboard;
import epam.com.SeleniumTestCases.orangeHRMPOM.pages.LoginPage;

public class JsLoginPage {

	private final WebDriver driver;

	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this);
	}

	public JsLoginPage enterUserName(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

//	public LoginPage clickButton() {
//		this.loginButton.click();
//		return this;
//	}
//	
	// Dashboard
	public Dashboard clickButton() {
		this.loginButton.click();
		return new Dashboard(driver);
	}
//	public LoginPage clickonButton()throws InterruptedException{
//		this.form.submit();
//		return this;
//	}
	
	 }

	
	 

	 }



