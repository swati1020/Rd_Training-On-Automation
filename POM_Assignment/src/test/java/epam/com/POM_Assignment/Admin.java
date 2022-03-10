package epam.com.POM_Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {
	private final WebDriver driver;

	public Admin(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	//for admin button click
	@FindBy(xpath = "(//a[@class='collapsible-header waves-effect waves-orange'])[1]")
	private WebElement admin;
	
	//for userManagement
	@FindBy(xpath = "//a[@href='#/admin/systemUsers']")
	private WebElement userManagement;

        //Clicking on user button
	@FindBy(xpath = "//span[@combinedmenutitle='Admin > User Management > Users']")
	private WebElement users;

	@FindBy(xpath = "(//i[@class='material-icons'][contains(.,'ohrm_edit')])[6]")
	
	private WebElement editButton;

	@FindBy(xpath = "(//i[contains(.,'arrow_drop_down')])[3]")
	private WebElement dropDownButton;

	@FindBy(xpath = "//span[@class='text'][contains(.,'Global Admin')]")
	private WebElement globalAdminAdd;

	@FindBy(xpath = "//button[@id='modal-save-button']")
	private WebElement saveButton;

@FindBy(xpath="//a[contains(@id,'bs-select-12-0')]")
private WebElement select;



////method for adminClick
public Admin adminClick() {
	this.admin.click();
	return this;
}
//method for userManagementClick
public Admin userManagementClick() {
	this.userManagement.click();
	return this;
}


	public Admin clickOnusersLeft() {
		this.users.click();
		return this;

	}

	public Admin editOnUsersPage() throws InterruptedException {

		Thread.sleep(8000);
		this.editButton.click();
		return this;
	}

	public Admin clickondropdown() throws InterruptedException {
		Thread.sleep(3000);
		this.dropDownButton.click();
		return this;
	}

	public Admin globalAdminOnUsersPage() throws InterruptedException {
		Thread.sleep(3000);
		this.globalAdminAdd.click();
		return this;
	}

	public Admin clickonSaveButton() throws InterruptedException {
		Thread.sleep(3000);
		this.saveButton.click();
		return this;
	}


}
