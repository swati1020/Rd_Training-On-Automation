package epam.com.SeleniumTestCases.orangeHRMPOM.pages;

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

public class LoginPage {

	private final WebDriver driver;

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

	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterUserName(String userName) {
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
	 public LoginPage printElementInput() {
		 System.out.print("number of elements" + inputFields.size());
		 for(Iterator iterator= inputFields.iterator();iterator.hasNext();) {
			 WebElement webElement=(WebElement) iterator.next();
			 System.out.println("Element"+ webElement.getTagName());
		 }
		 
		 System.out.print("number of elements" + inputFieldsBYS.size());
		 for(Iterator iterator= inputFieldsBYS.iterator();iterator.hasNext();) {
			 WebElement webElement=(WebElement) iterator.next();
			 System.out.println("Element"+ webElement.getTagName());
		 }
		 
		 System.out.print("number of elements" + inputFieldsBYALL.size());
		 for(Iterator iterator= inputFields.iterator();iterator.hasNext();) {
			 WebElement webElement=(WebElement) iterator.next();
			 System.out.println("Element"+ webElement.getTagName());
		 }
		return this;
	 }

	public Object loginButton() {
		// TODO Auto-generated method stub
		return null;
	}
	 
//	 @Test
//	 public void testLoginEnteringWrongPassword() {
//		 driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//		 
//		 driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//			driver.findElement(By.name("txtPassword")).sendKeys("U@qBLV");
//			driver.findElement(By.xpath("//button[@type='submit']")).click();
//			Assert.assertEquals("Admin", "U@qBLV");
//	 }
//
//	 public void testLoginEnteringDiv() {
//		 driver.get("https://prasoonr-trials73.orangehrmlive.com/");
//		 
//		 driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//			driver.findElement(By.name("txtPassword")).sendKeys("U@qBLV");
//			driver.findElement(By.xpath("//button[@type='submit']")).click();
////			Assert.assertEquals("Admin", "U@qBLV");
////			if(driver.getPageSource().contains("text")) {
////				System.out.print("yes present");
////			if(((driver.findElement(By.xpath("//button[@type='submit']"))!=null)&&(driver.getPageSource().contains("text"))){
//			assertTrue(!testLoginEnteringDiv(By.name("txtUsername")));
//			
//			}
	 }



