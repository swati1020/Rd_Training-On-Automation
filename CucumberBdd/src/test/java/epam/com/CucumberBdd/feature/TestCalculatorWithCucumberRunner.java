package epam.com.CucumberBdd.feature;


import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OrangeHRM.OrangeHRMPage;
import OrangeHRM.WebDriverFactoryProvider;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

	
	@CucumberOptions(features = "C:\\Users\\Swati_Deshwal\\TestAutomation\\CucumberBdd\\src\\main\\resources\\features\\loginFeature.feature", 
			glue = {
					"epam.com.CucumberBdd.feature" },
	  dryRun=true

			)
	
			public class TestCalculatorWithCucumberRunner {
                private TestNGCucumberRunner runner;
            	private static WebDriver driver;
            	private static String platformname;
            	private static String orangeHRMURL;
            	private OrangeHRMPage loginPage;
                @BeforeClass
                public void setup(ITestContext context) throws MalformedURLException {
                	runner =new TestNGCucumberRunner(this.getClass());
                	
                	String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
            		platformname = context.getCurrentXmlTest().getParameter("orangeHRMTestExecutionPlatform");
            		orangeHRMURL = context.getCurrentXmlTest().getParameter("orangeHRMBaseURL");
            		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
            		driver.get(orangeHRMURL);
//            		loginPage = new OrangeHRMPage(driver);
                }
                @Test(groups="cucumber", dataProvider="scenarios")
                public void testCucumberScenarios(PickleWrapper pickle, FeatureWrapper feature) {
                	runner.runScenario(pickle.getPickle());
                }
                @DataProvider
                public Object[][] scenarios(){
                	return runner.provideScenarios();
                }
                
                @AfterClass
                public void tearDownClass() {
                	runner.finish();
                }
}
