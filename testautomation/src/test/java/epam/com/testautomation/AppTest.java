package epam.com.testautomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import epam.com.testautomation.testing.App;

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
    public void testString() {
    	App app=new App();
    	String g=app.sendMsg();
    	assertEquals(g,"hello");
    }
}
