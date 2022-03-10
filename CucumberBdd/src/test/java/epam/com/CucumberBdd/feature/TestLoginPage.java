package epam.com.CucumberBdd.feature;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/CheckingloginScenario.feature", 
glue = {
		"epam.com.CucumberBdd.feature" }

)

public class TestLoginPage extends AbstractTestNGCucumberTests {

	@Test
	public void testDummy() {
		assertTrue(true);
	}

//	@BeforeTest
//	public void setUpClass(ITestContext context) {
//		try {
//			CucumberDefinitionImpl.setup(context);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

//}
