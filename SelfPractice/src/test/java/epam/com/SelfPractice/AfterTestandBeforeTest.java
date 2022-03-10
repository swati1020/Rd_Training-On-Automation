package epam.com.SelfPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public   class AfterTestandBeforeTest {
	
	@BeforeTest
//	@Test
	public void aftertest1() {
		System.out.println("Iam test before method");
	}

	@AfterTest
	@Test
	public void beforetest() {
		System.out.println("Iam test after method");
	}
	
	@BeforeClass
//	@Test
	public void afterclass() {
		System.out.println("Iam test class method");
	}
}
