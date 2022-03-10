package epam.com.SelfPractice;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//
//CucumberOption(
//		 features ="feature",
//		 glue= {"epam.com.SelfPractice"}
//		 )
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features = "C:\\Users\\Swati_Deshwal\\TestAutomation\\SelfPractice\\src\\test\\features\\loginbdd.feature", 
glue = {
		"epam.com.SelfPractice" },
dryRun=true

)

 public class LoginTestSauceDemo extends AbstractTestNGCucumberTests {
 
}
