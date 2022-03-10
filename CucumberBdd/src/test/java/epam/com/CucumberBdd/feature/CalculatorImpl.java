package epam.com.CucumberBdd.feature;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	
	@CucumberOptions(features = "C:\\Users\\Swati_Deshwal\\TestAutomation\\CucumberBdd\\src\\main\\resources\\features\\Calculator.feature", 
			glue = { "epam.com.CucumberBdd.feature" },
//			format = {"pretty","html:test-output","json:json_output/cucumber.json"}
//	format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" })
//			monochrome= true
//	 dryRun=true
//			tags="@DataTable"
	monochrome = true,plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" ,"junit:junit_xml/cucumber.xml" })
//			)
	
			public class CalculatorImpl extends AbstractTestNGCucumberTests {

}
