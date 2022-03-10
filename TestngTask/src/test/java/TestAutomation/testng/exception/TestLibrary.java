package TestAutomation.testng.exception;
import static org.testng.Assert.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import epam.com.TestngTask.MemberClass;

//import org.junit.Test;

public class TestLibrary {
	LibProject l;
	
	@BeforeClass
	@org.testng.annotations.Test
	public void testaddMember() {
		l=new  LibProject();
		l.AddMember(new MemberClass(1,"Swati","Deshwal","delhi",23,true));
		l.AddMember(new MemberClass(2,"anu","sharma","pune",20,true));
		l.AddMember(new MemberClass(3,"anjali","mishra","pune",22,true));
		l.AddMember(new MemberClass(4,"anu","sharma","pune",24,false));
		System.out.println("success");
		assertEquals(l.getofSize(),4);
	}
	
	@DataProvider(name="issueToMember")
	public static Object[][] issueBookToMembers()
	{
		return new Object[][] {
			{1,2},
			{2,1},
			{2,2},
			{3,3},
			{1,1},
			
			};
	}
	@Test(dataProvider ="issueToMember")
	
	public void displayingNumbers(int a,int b){
//		String
		System.out.println(a +" " +b);
		
	}
	@Test
	@BeforeMethod
	public void testaddMember1() {
		LibProject l = new LibProject();
		l.AddMember(new MemberClass(1,"Swati","Deshwal","delhi",23,true));
		System.out.println("Learning");
		assertEquals(l.getofSize(),1);
	}
	
//	@Test
	public void issuedBook(int bookid, int memid) {
		Admin1 admin=new Admin1();
		admin.issueBookToMember(1,1);
//		assertEquals(1,1);
		Assert.assertEquals(1, 1);
		System.out.println("Learning");

		
	}
	@Test(dataProvider = "csvdataprovider")
	public void testAddMembers(int memberID, String firstname, String lastName, String city, int age, Boolean status)
	{
		int initialSize = l.list.size();
		l.AddMember(new MemberClass(memberID, firstname, lastName, city, age,status));
		assertEquals(l.list.size(), initialSize + 1);
	}
	
	

	@DataProvider(name = "csvdataprovider")
	private Object[][] csvReader() throws Exception
	{
		Object[][] data = new Object[3][6];
		int index = 0;
		  CSVReader reader = new CSVReader(new FileReader("src/test/resources/test.csv"));
	      
	      String line[];
	      while ((line = reader.readNext()) != null) {
	         data[index][0] = Integer.parseInt(line[0]);
	         data[index][1] = line[1];
	         data[index][2] = line[2];
	         data[index][3] = line[3];
	          data[index][4] = Integer.parseInt(line[4]);
	          data[index][5] = Boolean.parseBoolean(line[5]);
	        index++;
	         
	      }
	      reader.close();
	      return data;
	      
	}
	
}
	

	

	
	
