package epam.com.TestngTask;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class testlib {

	Library lib;
	
	
	@BeforeGroups(groups = {"basicOperation","Alltests"})
	public void initializeLibrary()
	{
		lib = new Library();
		lib.setCatalouge(new CatalogueClass());
		lib.setAdmin(new Admin(lib));
		
		System.out.println("Initializing Library");
		
		lib.getCatalouge().addBook(new Book(1, "Angels & Demons", "Dan Brown"));
		lib.getCatalouge().addBook(new Book(2, "Lost Symbol", "Dan Brown"));
		lib.getCatalouge().addBook(new Book(3, "Ramayana", "Valmiki"));
	}
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testAddMember()
	{
		int initialSize = lib.getMembers().size();
		lib.addMember(new Member(5, "Anuj", "Sharma", "Surat", 15));
		assertEquals(lib.getMembers().size(), initialSize + 1);
		
	}
	
	@Test(groups = {"basicOperation","Alltests"}, dataProvider = "csvdataprovider2")
	public void testAddMember(int memberID, String firstname, String lastName, String city, int age)
	{
		int initialSize = lib.getMembers().size();
		lib.addMember(new Member(memberID, firstname, lastName, city, age));
		assertEquals(lib.getMembers().size(), initialSize + 1);
	}
	
	
	
	@DataProvider(name = "csvdataprovider")
	private Object[][] csvReader() throws Exception
	{
		Object[][] data = new Object[100][5];
		int index = 0;
		  CSVReader reader = new CSVReader(new FileReader("src/main/resources/Member.csv"));
	      
	      String line[];
	      while ((line = reader.readNext()) != null) {
	         data[index][0] = Integer.parseInt(line[0]);
	         data[index][1] = line[1];
	         data[index][2] = line[2];
	         data[index][3] = line[3];
	         data[index][4] = Integer.parseInt(line[4]);
	         index++;
	      }
	      reader.close();
	      return data;
	      
	}
	
	
	
	@DataProvider(name = "csvdataprovider2")
	private Iterator<Object[]> csvReader2() throws Exception
	{
		List<Object[]> data = new ArrayList();
		
		  CSVReader reader = new CSVReader(new FileReader("src/main/resources/Member.csv"));
	      String line[];
	      while ((line = reader.readNext()) != null) {
	    	  Object[] member = new Object[5];
	         member[0] = Integer.parseInt(line[0]);
	         member[1] = line[1];
	         member[2] = line[2];
	         member[3] = line[3];
	         member[4] = Integer.parseInt(line[4]);
	         
	         data.add(member);
	         
	      }
	      reader.close();
	    
	      return data.iterator();
	      
	}
	
	
}

