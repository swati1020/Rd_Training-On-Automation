package epam.com.CucumberBdd.feature;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import OrangeHRM.WebDriverFactoryProvider;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalculatorStepDefination extends TestCalculatorWithCucumberRunner {
	private static WebDriver driver;
	private static String platformname;
	private static String browserName;
	private static String calculatorURL;
	private static CalculatorPage calculatorPage;
	
	@BeforeAll
	public static void setup() throws MalformedURLException{
		browserName = "chrome";
		platformname = "LocalWebDriver";
		calculatorURL = "C:/Users/Swati_Deshwal/TestAutomation/CucumberBdd/src/main/calculator.html";
		driver=WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		driver.get(calculatorURL);
		driver.navigate().to(calculatorURL);
		calculatorPage = new CalculatorPage(driver);
	}

	@Given("Browser is open")
	public static void browser_is_loaded() throws MalformedURLException {
//		browserName = "chrome";
//		platformname = "LocalWebDriver";
//		calculatorURL = "C://calculator.html";
//		driver=WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
//		driver.navigate().to(calculatorURL);
//		calculatorPage = new CalculatorPage(driver);
	}

	@Given("Calculator page is open")
	public void calculator_page_is_open() {
		
	}

	@Then("Calculator has number {string}")
	public void calculator_has_number(String buttonLabel) {
		calculatorPage.buttonWithLabelExists(buttonLabel);
	}

	@Then("Calculator has operator {string}")
	public void calculator_has_operator(String buttonLabel) {
		calculatorPage.buttonWithLabelExists(buttonLabel);
	}

	@Then("Calculator has display field")
	public void calculator_has_display_field() {
		calculatorPage.displayFieldExists();
	}

	@Then("Calculator {string} has color {string}")
	public void calculator_has_color(String buttonLabel, String color) {
		calculatorPage.buttonColorMatches(buttonLabel, color);
	}

	@Given("number button is clicked {string}")
	public void number_button_is_clicked(String buttonLabel) {
		calculatorPage.clickButton(buttonLabel);
	}

	@Given("Operator button is clicked {string}")
	public void operator_button_is_clicked(String buttonLabel) {
		calculatorPage.clickButton(buttonLabel);
	}

	@Given("Number button is click {string}")
	public void number_button_is_click(String buttonLabel) {
		calculatorPage.clickButton(buttonLabel);
	}

	@Then("display screen should have number {string}")
	public void display_screen_should_have_number(String text) {
	// Write code here that turns the phrase above into concrete actions
	calculatorPage.displayScreenText(text);

	}
	
	@Given("following button are clicked")
	public void button_are_clicked(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> values= dataTable.asLists(String.class);
	       for(Iterator iterator=values.iterator(); iterator.hasNext();)
	       {
	    		   List<String> list =(List<String>)iterator.next();
	    		   for(Iterator iterator2=list.iterator();iterator2.hasNext();) {
	    			   String string=(String)iterator2.next();
	    			   System.out.println("Values"+ string);
	    		   }
	       }
	}
	@Then("display field should have {int}")
	public void display_field_should_have(Integer int1) {
	    
	}
}