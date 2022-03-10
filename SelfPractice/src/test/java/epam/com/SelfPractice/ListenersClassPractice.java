package epam.com.SelfPractice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListenersClassPractice {
	
	@Test
	public void emailId() {
		Assert.assertEquals("deshwal", "deshwal");
		System.out.print("Email id is printing");
	}
	@AfterClass
//	@Test(priority=1,description="company ID")
//	@Test(enabled=false)
	@Test
	public void companyId() {
		Assert.assertEquals("swati", "swati");
		System.out.print("Company id is printing");
	}

}
