package UiUsingSelenium.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class PunchOut {

	private WebDriver driver;
	
	@FindBy(xpath="//input[@name='dateTextInput']")
	private WebElement punchOutDate;
	
	@FindBy(xpath="//input[@id='time']")
	private WebElement punchOutTimeButton;
	
	@FindBy(xpath="//div[@id='allowedActionButtonsDiv']/button[@type='button']")
	private WebElement punchOutButton;
	
	@FindBy(xpath="//span[contains(text(),'Punch out time should be later than punch in time')]")
	private WebElement invalidPunchOut;
	
	@FindBy(xpath="//div[@id='allowedActionButtonsDiv']/button[@type='button']")
	private WebElement OutButtonError;
	
    public PunchOut(WebDriver driver) {
	this.driver = driver;
	AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
	PageFactory.initElements(factory, this);
}
	
	public PunchOut selectPunchOutDateFromPunchInOutPage(String date) throws InterruptedException {
		Thread.sleep(3000);
	this.punchOutDate.click();
	this.punchOutDate.clear();
	this.punchOutDate.sendKeys(date);
	return this;
	}


	public PunchOut clickOnPunchOutTimeButtonFromPunchInOutPage(String time) throws InterruptedException {
	this.punchOutTimeButton.click();
	this.punchOutTimeButton.clear();
	this.punchOutTimeButton.sendKeys(time);
	return this;
	}
	
	public AttendanceSheet clickOnPunchOutButton() throws InterruptedException {
		Thread.sleep(5000);
		this.punchOutButton.click();
		return new AttendanceSheet(driver);
	}
	
	

	public PunchOut verifyInvalidPunchOutMessage() throws InterruptedException {
	String invalidMessage=invalidPunchOut.getText();
	System.out.println();
	assertEquals(invalidMessage,"Punch out time should be later than punch in time");
	return this;
	}


	public PunchOut clickOutButtonError() throws InterruptedException {
	this.OutButtonError.click();
	return this;
	}
	
	
	public PunchOut verifingclickOnPunchOutButtonfailedButton() throws InterruptedException {
		WebElement failedText= driver.findElement(By.xpath("div[@class='toast-message']"));
		String failedMessage= failedText.getText();
		Assert.assertEquals(failedMessage , failedText);
		return this;
	}

	
	public PunchOut verifingClickOnPunchOutButtonSuccessButton() throws InterruptedException {
		WebElement successText= driver.findElement(By.xpath("div[@class='toast-message']"));
		String successMessage= "Successfully Saved";
				 Assert.assertEquals(successMessage , successText);
		return this;
	}


}

