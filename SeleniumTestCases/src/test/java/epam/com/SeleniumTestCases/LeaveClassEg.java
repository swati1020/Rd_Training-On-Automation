package epam.com.SeleniumTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.beust.j.Parameters;

public class LeaveClassEg {
	WebDriver driver;
	@Test
	@BeforeClass
	@Parameters("browserName")
	public void leave(String browserName) throws InterruptedException {

		driver = UiAutomationFactoryAssignment2.factory(browserName);
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//leave
		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/a")).click();
		//click on apply leave
		Thread.sleep(30000);
//		driver.findElement(By.xpath("//*[@id=\"menu_leave_applyLeave\"]/span[2]")).click();
		//dropdown
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS );
		//for date

		driver.findElement(By.xpath("//li/a[span=\"Leave\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_leave_applyLeave\"]/span[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"leaveType_inputfileddiv\"]/div/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li/span[contains(text(),'Sick Leave - US')]")).click();
		driver.findElement(By.xpath("//span/span/i")).click();
		driver.findElement(By.id("from")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id=\"P516280532_table\"]/tbody/tr[1]/td[5]/div")).click();
		driver.findElement(By.xpath("(//div[@name='dateForm'])[2]")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//div[@name='dateForm'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='input-field col s12 m12 l6 ng-valid-pattern ng-valid-display-input-validity ng-valid-date-range ng-dirty']")).click();
		Thread.sleep(5000);
		
	    }
	}


