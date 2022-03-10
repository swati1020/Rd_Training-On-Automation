package epam.com.SeleniumTool.LoginPageListnerImpl;

//import java.util.Collection;
//
//import java.util.Date;
//
//import java.util.List;
//
//import java.util.Map;
//
//import java.util.Set;
//
//import org.testng.IReporter;
//
//import org.testng.IResultMap;
//
//import org.testng.ISuite;
//
//import org.testng.ISuiteResult;
//
//import org.testng.ITestContext;
//
//import org.testng.ITestNGMethod;
//
//import org.testng.xml.XmlSuite;
//
//public class IReporterImpl implements IReporter {
//	@Override
//
//	public void generateReport(List<XmlSuite> xmlsuit, List<ISuite> suit, String outputDirectory) {
//
//// Second parameter of this method ISuite will contain all the suite executed.
//
//		for (ISuite iSuite : suit) {
//
////Get a map of result of a single suite at a time
//
//			Map<String, ISuiteResult> results = iSuite.getResults();
//
////Get the key of the result map
//
//			Set<String> keys = results.keySet();
//
////Go to each map value one by one
//
//			for (String key : keys) {
//
////The Context object of current result
//
//				ITestContext context = results.get(key).getTestContext();
//
////Print Suite detail in Console
//
//				System.out.println("Suite Name->" + context.getName()
//
//						+ "::Report output Ditectory->" + context.getOutputDirectory()
//
//						+ "::Suite Name->" + context.getSuite().getName()
//
//						+ "::Start Date Time for execution->" + context.getStartDate()
//
//						+ "::End Date Time for execution->" + context.getEndDate());
//
////Get Map for only failed test cases
//
//				IResultMap resultMap = context.getFailedTests();
//
////Get method detail of failed test cases
//
//				Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();
//
////Loop one by one in all failed methods
//
//				System.out.println("--------FAILED TEST CASE---------");
//
//				for (ITestNGMethod iTestNGMethod : failedMethods) {
//
////Print failed test cases detail
//
//					System.out.println("TESTCASE NAME->" + iTestNGMethod.getMethodName()
//
//							+ "\nDescription->" + iTestNGMethod.getDescription()
//
//							+ "\nPriority->" + iTestNGMethod.getPriority()
//
//							+ "\n:Date->" + new Date(iTestNGMethod.getDate()));
//
//				}
//
//			}
//
//		}
//
//	}
//
//}
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ReporterImpl implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xml, List<ISuite> testsuit, String outputDir) {
		
		// Second parameter of this method ISuite will contain all the suite executed.
		
		
		for (ISuite suit : testsuit) {

			System.out.println("Suite names are displayed - " + suit.getName());

			//Get a map of result of a single suite at a time

			Map<String, ISuiteResult> suiteResults = suit.getResults();

			//Get the key of the result map
			for (ISuiteResult suitresult : suiteResults.values()) {

				ITestContext testcontext = suitresult .getTestContext();

				//Print Suite detail in Console
				System.out.println("Test tag name: " + testcontext.getName() + " Test start time: " + testcontext.getStartDate()
						+ " Test end time: " + testcontext.getEndDate() + " Test report output dir: " +testcontext.getOutputDirectory());

				//checking for failed methods
				Collection<ITestNGMethod> failedMthds = testcontext.getFailedTests().getAllMethods();

				System.out
						.println("Total failed methods: " + failedMthds.size() + " and those are: " + failedMthds);

				for (ITestNGMethod failed : failedMthds) {
					System.out.println("Name: " + failed.getMethodName());
				}
				System.out.println("Failed tests are :" + testcontext.getFailedTests().getAllResults());
				System.out.println("Skipped tests are:" + testcontext.getSkippedTests().getAllResults());
				System.out.println("Passed tests are :" + testcontext.getPassedTests().getAllResults());
				
			}
		}
		System.out.println("Path - " + outputDir);
	}
}
