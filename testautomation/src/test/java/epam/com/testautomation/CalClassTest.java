package epam.com.testautomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import Calulator.CalClass;

public class CalClassTest extends CalClass {
	
//	protected void setUp() throws Exception{
//		super.setUp();
//		CalClass c= new CalClass();
//	}

		@Test
		public void add1() {
		CalClass c=new CalClass();
		int a=c.add(2,4);
		assertEquals(6,a);
		}
		@Test
		public void mul1() {
			CalClass c=new CalClass();
		int b=c.mul(2,4);
		assertEquals(8,b);
		}
		@Test
		//checking the sub method
		public void sub1() {
			CalClass c=new CalClass();
			int subt=c.sub(2,2);
			assertEquals(0,subt);
			}
		
		public void div1() {
			CalClass c=new CalClass();
			try {
				Integer result=c.div(10, 2);
			}catch(Exception e) {
				assertThrows(ArithmeticException.class,() ->c.div(10, 0) );
			}
		}

//		private void assertThrows(Class<ArithmeticException> class1, Exception e) {
//			// TODO Auto-generated method stub
//			
//		}

	}

//}
