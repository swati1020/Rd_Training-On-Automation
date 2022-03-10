package epam.com.SelfPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEg {

	@Test(dataProvider="practiceClassOfDataProvide")
	
	public void test(String username, String pswd) {
		System.out.println(username+"========"+pswd);
	}
	
	@Test(dataProvider="practiceClassOfDataProvide")
	
	public void test(String username, String pswd,String test) {
		System.out.println(username+"========"+pswd + test);
//		dataset[0][1]="user1"
	}
	

	@DataProvider
 public Object[][] practiceClassOfDataProvide() {
		Object dataset[][]=new Object[3][2];
		dataset[0][0]="user1";
		dataset[0][1]="pswd1";
		//row 2 and for user 2 details
		dataset[1][0]="user2";
		dataset[1][1]="pswd2";
		//row 3 and for user 3 details
		dataset[2][0]="user3";
		dataset[2][1]="pswd3";
		
		return dataset;
		
	}
			
		
}
