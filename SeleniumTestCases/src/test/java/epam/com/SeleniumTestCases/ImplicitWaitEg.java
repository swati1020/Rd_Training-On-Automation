package epam.com.SeleniumTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImplicitWaitEg {

	@Test
	public void loadWebDriver() throws InterruptedException {

		String driverPath = "C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);

		WebDriver driver = new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com");
		driver.manage().window().maximize();

                     //trying with implicitWait 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//Navigating
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.xpath("//span[text()='User Management']")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();

//Thread.sleep(5000);

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[9]/i"))
				.click();
//Thread.sleep(5000);
		driver.findElement(
				By.xpath("/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button"))
				.click();
		driver.findElement(By.id("bs-select-3-2")).click();
// for save button
		driver.findElement(By.id("modal-save-button")).click();
//Thread.sleep(2000);
		String s = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span"))
				.getText();
		String arr[] = s.split(",");
		assertEquals(arr[2], " Global Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[9]/i"))
				.click();
//Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button/i[2]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"bs-select-6-0\"]")).click();
		driver.findElement(By.id("modal-save-button")).click();
//Thread.sleep(5000);
		String s1 = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span"))
				.getText();
		String arr1[] = s1.split(",");
		assertEquals(arr1.length, 2);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/a/span[2]/i")).click();
		driver.findElement(By.id("logoutLink")).click();
	}
}
