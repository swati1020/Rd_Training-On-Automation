package epam.com.SeleniumTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadioButtonandCheckBox {
	WebDriver driver;
	@Test
	@BeforeClass
//	@Parameters("browserName")
	
	public void radioButton() throws InterruptedException {

		String driverPath = "C:\\Users\\Swati_Deshwal\\TestAutomation\\SeleniumTestCases\\src\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/client/#/pim/employees/13/personal_details");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("U@qBLVtm09");
         driver.findElement(By.xpath("//button[@type='submit']")).click();
//        going in info tab
                   
         //Explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));



        wait.until(ExpectedConditions
        .presenceOfElementLocated(By.xpath("//ul[@class='radiobutton-container']/li[1]/label")));
        WebElement radio2 = driver.findElement(By.xpath("//ul[@class='radiobutton-container']/li[2]/label"));
        radio2.click();



        driver.findElement(By.xpath("//label[@for=\"26Dairy-Free\"]")).click();
        driver.findElement(By.xpath("//label[@for=\"26Gluten-Free\"]")).click();
//        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
//        Thread.sleep(5000);
////        for check button
//        driver.findElement(By.xpath("//ul[@class='radiobutton-container']/li[2]/label")).click();
////        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/ui-view/div[2]/div/custom-fields-panel/div[1]/form/materializecss-decorator[1]/div/sf-decorator[1]/div/ul/li[2]/label")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div/input[@id=\"26Dairy-Free\"]")).click();
//       
	}

}////ul/li[2]/label[@for="30_Yes"]  for check//div/input[@id="26Dairy-Free"]
