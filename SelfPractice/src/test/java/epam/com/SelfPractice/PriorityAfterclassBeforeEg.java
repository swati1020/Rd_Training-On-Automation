package epam.com.SelfPractice;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityAfterclassBeforeEg {
     @Test
	public void atest() {
		System.out.println("ATEST1");
	}
//     @BeforeClass
     @Test
	public void beforeClassMethod() {
		System.out.println("Hi im before class");// 1
	}

//	@AfterClass
	@Test
	public void afterClassmethod() {
		System.out.println("I'm AfterClass");// 2
	}
  @Test(priority = -1)
	public void priorityMethod() {
		System.out.println("im priority");
	}

}
