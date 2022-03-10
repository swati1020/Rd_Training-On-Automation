package epam.com.OrangerHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard {

	@FindBy(xpath="//a[@id='logoutLink']")
	private WebElement logoutLink;



	@FindBy(xpath="//i[contains(text(), 'keyboard_arrow_down')]")
	private WebElement downArrow;
	 WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public OrangeHRMPages logout() {
		downArrow.click();
		logoutLink.click();

		return new OrangeHRMPages(driver);
		}

}
