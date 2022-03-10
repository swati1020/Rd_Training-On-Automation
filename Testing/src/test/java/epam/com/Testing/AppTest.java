package epam.com.Testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

//import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
@Test
    public void testApp1()
    {
        System.out.println("I'm learning");
    }
@Test
    public void testApp2()
    {
        System.out.println("I'm learning");
    }
     @BeforeTest
	public void beforetest() {
		System.out.println("excuting the before test");
	}
	
     @AfterTest
	public void aftertest() {
		System.out.println("excuting the after test");
	}
     
     @AfterMethod
 	public void afterMethod() {
		System.out.println("excuting the after method");
	}
 	
     @BeforeMethod
 	public void beforeMethod() {
		System.out.println("excuting the after method");
	}
     
      
}
