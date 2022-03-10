package epam.com.SeleniumTestCases.guru99;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import epam.com.SeleniumTestCases.UiAutomationFactoryAssignment2;

public class TestGuru99 {
	
	WebDriver driver;

		@BeforeClass
		@Parameters("browser")
		public void setup(String Browser) {
			driver = UiAutomationFactoryAssignment2.factory(Browser);
//			driver.get("https://demo.guru99.com/test/delete_customer.php");
//			driver.get("https://demo.guru99.com/articles_popup.php");
			driver.get("https://demo.guru99.com/test/drag_drop.html");
			driver.manage().window().maximize();

		}
		@Test(enabled=false)
		public void testAlertAccept() {
			driver.findElement(By.name("cusid")).sendKeys("Admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.name("submit")).click();
			String print=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			System.out.print(print);
		}

		@Test(enabled=true)
			public void windowHandle() {
			driver.findElement(By.xpath("/html/body/p/a")).click();
//			driver.findElement(By.name("emailid")).sendKeys("123@gmail.com");
//	         driver.findElement(By.name("btnLogin")).click();
			driver.findElement(By.name("submit")).click();
			System.out.print("print");
			String str=driver.getWindowHandle();
			Set<String> s=driver.getWindowHandles();
			Iterator<String>i=s.iterator();
			while(i.hasNext()) {
				String child=i.next();
				if(!str.equalsIgnoreCase(child)) {
					driver.switchTo().window(child);
					driver.findElement(By.name("emailid")).sendKeys("123@gmail.com");
					
				}
			}
		}
		
     @Test(enabled=false)
		
		public void alertSwitchAccept() {
		driver.findElement(By.name("cusid")).sendKeys("Admin");
         driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.name("submit")).click();
		String print=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.print(print);
		}
		
		@Test(enabled=true)
			public void dragAndDrop() {
		driver.manage().timeouts().implicitlyWait(310,TimeUnit.SECONDS);
		
		WebElement fromcredit=driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		WebElement toBank=driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		Actions action=new Actions(driver);
		action.dragAndDrop(fromcredit, toBank).perform();

	}
}
