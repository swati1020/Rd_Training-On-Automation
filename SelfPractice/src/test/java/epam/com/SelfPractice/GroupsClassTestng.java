package epam.com.SelfPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupsClassTestng {

	@Test(groups="smoke")
	public void atest() {
   System.out.println("ATEST1");
	}

	@Test(groups="smoke")
	public void fromAgroup() {
		 System.out.println("ATEST2");
	}
	@BeforeClass
//	@Test(groups = {"smoke","unit"})
	public void beforeClassMethod() {
		 System.out.println("Hi im before class");//1
	}
	@AfterClass
	@Test(groups="unit")
	public void afterClassmethod() {
		 System.out.println("I'm AfterClass");//2
	}
	@Test(priority=1, groups="unit")
	public void priorityMethod() {
		 System.out.println("im priority");
	}
	
	@Test(groups="unit" )
	public void bgroupMethod() {
		 System.out.println("last line from bB group");
	}

}
