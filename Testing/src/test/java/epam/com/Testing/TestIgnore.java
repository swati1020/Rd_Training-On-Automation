package epam.com.Testing;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TestIgnore {
	@Test
	public void testApp1() {
//		System.out.println("run");
		assertTrue(true);
	}
	@Test(enabled= false)
	public void testApp2() 
	{
//		System.out.println("running now!!!!!!!!");
		assertTrue(true);
	}

}
