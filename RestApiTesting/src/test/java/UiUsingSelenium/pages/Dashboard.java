package UiUsingSelenium.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class Dashboard {

	@FindBy(xpath="//a[@id='logoutLink']")
	private WebElement logoutLink;



	@FindBy(xpath="//i[contains(text(), 'keyboard_arrow_down')]")
	private WebElement downArrow;
	
    @FindBy(id="menu_attendance_Attendance")
		private WebElement attendanceButton;
    
    @FindBy(xpath="//span[text()='Punch In/Out']")
	private WebElement attendanceMyPunchIn;
    
    @FindBy(xpath="//span[contains(text(),'My Attendance Sheet')]")
	private WebElement myAttendanceSheetButton;
	 
	 WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public LoginPage logout() {
		downArrow.click();
		logoutLink.click();

		return new LoginPage(driver);
		}
	
	public Dashboard clickAttendanceMenu() {
		this.attendanceButton.click();
		return this;
		}
	

	public PunchInPage clickOnPunchinPunchOutMenu() throws InterruptedException {
//		Thread.sleep(3000);
		this.attendanceMyPunchIn.click();
//		String actualTitle= driver.getTitle();
//	    String exceptedTitle= "Punch In/PunchOut";
//	    Assert.assertEquals(exceptedTitle , actualTitle);
		String actualTitle= driver.getCurrentUrl();
	    String exceptedTitle= "my_punch_in_out";
	    assertTrue(actualTitle.contains(exceptedTitle));
		return new PunchInPage(driver);
	}
	
	public AttendanceSheet clickOnMyAttendanceSheetButton() throws InterruptedException {
//		Thread.sleep(3000);
		this.myAttendanceSheetButton.click();
		return new AttendanceSheet(driver);
		}
	
}
