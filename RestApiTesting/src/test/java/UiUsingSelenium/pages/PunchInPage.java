package UiUsingSelenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class PunchInPage {

	private WebDriver driver;
	
	@FindBy(xpath="//input[@name='dateTextInput']")
	private WebElement punchInDate;
	
	@FindBy(xpath="//input[@id='time']")
	private WebElement timeButton;
	
	@FindBy(xpath="//div[@id='allowedActionButtonsDiv']/button[@type='button']")
	private WebElement punchInButton;

	

	   public PunchInPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	   
	      public PunchInPage selectPunchInDateFromPunchInOutPage(String date) throws InterruptedException {
	       this.punchInDate.click();
	       this.punchInDate.clear();
	       this.punchInDate.sendKeys(date);
	       return this;
	}	
		
	 public PunchInPage verifingClickOnPunchInButtonSuccessButton() throws InterruptedException {
	  WebElement successText= driver.findElement(By.xpath("div[@class='toast-message']"));
	  String successMessage= "Successfully Saved";
		Assert.assertEquals(successMessage , successText);
		return this;
		}

	 
    public PunchInPage clickOnPunchInTimeButton(String time) throws InterruptedException {
	Thread.sleep(5000);
	this.timeButton.click();
	this.timeButton.clear();
	this.timeButton.sendKeys(time);
	return this;
	}
		
	public PunchInPage verifingClickOnPunchOutButtonSuccessButton() throws InterruptedException {
		WebElement successText= driver.findElement(By.xpath("div[@class='toast-message']"));
		String successMessage= "Successfully Saved";
	    Assert.assertEquals(successMessage , successText);
		return this;
	}

    
	
        public PunchOut clickOnPunchInButton() throws InterruptedException {
		Thread.sleep(6000);
		this.punchInButton.click();
		return new PunchOut(driver);
		}
}
