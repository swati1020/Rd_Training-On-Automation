package epam.com.CucumberBdd.feature;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Admin {
	private final WebDriver driver;

	public Admin(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	private WebElement admin;

	@FindBy(xpath = "//span[contains(text(),'User Management')]")
	private WebElement userManagement;

	@FindBy(xpath = "//span[contains(text(),'Users')]")
	private WebElement users;

	@FindBy(xpath = "//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")
	private WebElement edit;

	@FindBy(xpath = "(//i[contains(text(),'arrow_drop_down')])[3]")
	private WebElement dropDown;

	@FindBy(xpath = "//span[@class='text'][contains(text(),'Global Admin')]")
	private WebElement globalAdmin;

	@FindBy(xpath = "//button[@id='modal-save-button']")
	private WebElement save;

	@FindBy(xpath = "(//a[contains(.,'-- Select --')])[3]")
	private WebElement select;

	@FindBy(xpath = "(//span[contains(text(),'Default ESS, Default Supervisor')])[6]")
	private WebElement verify;

	@FindBy(xpath = "//a[@id='logoutLink']")
	private WebElement logout;

	@FindBy(xpath = "//i[contains(text(), 'keyboard_arrow_down')]")
	private WebElement downArrow;

	public Admin clickOnAdminInLeftPanel() {
		this.admin.click();
		return this;
	}

	public Admin clickOnUserManagementLeftPanel() {
		this.userManagement.click();
		return this;
	}

	public Admin clickOnUsersLeftPanel() {
		this.users.click();
		return this;

	}

	public Admin clickOnEditOnUsersPage() throws InterruptedException {

		Thread.sleep(8000);
		this.edit.click();
		return this;
	}

	public Admin clickOnDropdownOnUsersPage() throws InterruptedException {
		Thread.sleep(3000);
		this.dropDown.click();
		return this;
	}

	public Admin clickOnGlobalAdminOnUsersPage() throws InterruptedException {
		Thread.sleep(3000);
		this.globalAdmin.click();
		return this;
	}

	public Admin clickOnSaveOnUsersPage() throws InterruptedException {
		Thread.sleep(3000);
		this.save.click();
		return this;
	}

	public Admin clickOnSelectOnUsersPage() throws InterruptedException {
		Thread.sleep(3000);
		this.select.click();
		return this;
	}

	public Admin verifyGlobalAdmin() throws InterruptedException {
		Thread.sleep(3000);
		this.verify.click();
		String s = verify.getText();
		String arr[] = s.split(",");
		assertEquals(arr[2], " Global Admin");
		return this;
	}

	public Admin clickOnDownArrowForLogout() throws InterruptedException {
		Thread.sleep(3000);
		this.downArrow.click();
		return this;
	}

	public Admin clickForLogout() throws InterruptedException {
		Thread.sleep(3000);
		this.logout.click();
		return this;
	}

	public Admin verifyGlobalAdminAfterDeleting() throws InterruptedException {
		Thread.sleep(3000);
		this.verify.click();
		String s = verify.getText();
		String arr[] = s.split(",");
		assertEquals(arr.length, 2);
		return this;
	}

}