package UiUsingSelenium.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AttendanceSheet{

	private WebDriver driver;
		

		@FindBy(xpath="//span[contains(text(),'My Attendance Sheet')]")
		private WebElement myAttendanceSheetButton;
		
		@FindBy(xpath = "//div[@class='pay-hours-duration pay-hours-duration-0']")
		private WebElement totalTimeHours;
		
		  @FindBy(xpath="//li[@id='date_2022-03-10']/div")
          private WebElement dateButton;
		  

          @FindBy(xpath="//button[@data-icon='delete_forever']")
          private WebElement deleteMessage;
		  
		  private WebElement deleteButton;
		
	    public AttendanceSheet(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
		
	    
	      public AttendanceSheet clickOnMyAttendanceSheetButton() throws InterruptedException {
	    	  Thread.sleep(5000);
			this.myAttendanceSheetButton.click();
			assertTrue(driver.getCurrentUrl().endsWith("my_attendance_sheet"));
			return this;
			}
	      
	    
	           public AttendanceSheet checkingTheTotalTimeHours() throws InterruptedException {
	        	   Thread.sleep(5000);
				String time=this.totalTimeHours.getText();
				System.out.println(time);
				return this;
				}
	           
	         

	           public AttendanceSheet clickOnDateButtonFromMyAttendanceSheet() throws InterruptedException {
	           Thread.sleep(5000);
	           this.dateButton.click();
	           return this;
	           }
	          

	           public AttendanceSheet clickDeleteButtonFromMyAttendanceSheet(String date) throws InterruptedException {
	           Thread.sleep(5000);
	           deleteButton=driver.findElement(By.xpath("//div[@class='timesheetDate'][(text()=\""+date+"\")]//parent::span//parent::div//parent::li//div[@aria-label='Delete']"));
	           this.deleteButton.click();
	           return this;
	           }
	           
	           

	           public AttendanceSheet clickOnDeleteMessageFromMyAttendanceSheet() throws InterruptedException {
	           Thread.sleep(5000);
	           this.deleteMessage.click();
	           return this;
	           }
	      
	      
}
