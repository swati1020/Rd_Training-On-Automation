package epam.com.SelfPractice.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchingElemntInChromeByUsingPom {
	
 static WebDriver driver;
	static WebElement ele=null;
	
	public  WebElement google() {
//	 ele=	driver.findElement(By.name("q")).sendKeys("abcd");
	 ele=	driver.findElement(By.name("q"));
	 ele.sendKeys("abcd");
	return ele;
		
	}
	public  WebElement search() {
		ele= driver.findElement(By.name("btnK"));
		ele.click();
		return ele;
	}

}
