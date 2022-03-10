package epam.com.testautomation.testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import java.util.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestCatalogue {
	
	Library lib;
	
	
	@BeforeGroups(groups = {"basicOperation","Alltests"})
	public void initializeLibrary()
	{
		lib = new Library();
		lib.setCatalogue(new Catalogue());
		
		System.out.println("Initializing Library");
		
		lib.getCatalogue().addBook(new Book(1, "Angels & Demons", "Dan Brown"));
		lib.getCatalogue().addBook(new Book(2, "Lost Symbol", "Dan Brown"));
		lib.getCatalogue().addBook(new Book(3, "Ramayana", "Valmiki"));
	}
	
	
	
	
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testCatalogueAddBook()
	{
		int initialSize = lib.getCatalogue().getCatalougeSize();
		lib.getCatalogue().addBook(new Book(4, "Mahabhartha", "VedVyas"));
		
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize + 1);
		
	}

	
	
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testCatalogueRemoveBook()
	{
		int initialSize = lib.getCatalogue().getCatalougeSize();
		int idToRemove = lib.getCatalogue().getBooks().get(0).getId();
		
		lib.getCatalogue().removeBook(idToRemove);
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize - 1);
		
	}
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testCatalogueRemoveNonExistingBook()
	{
		int initialSize = lib.getCatalogue().getCatalougeSize();
		
		lib.getCatalogue().removeBook(102);
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize);
		
	}
	
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByBookName()
	{
		Book book = lib.getCatalogue().searchBook("Symbol");
		
		assertNotNull(book);
	
	}
	
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByBookNamewhichDoesNotExist()
	{
		Book book = lib.getCatalogue().searchBook("Geeta");
		
		assertNull(book);
	
	}
	
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByAuthorname()
	{
		Book book = lib.getCatalogue().searchBook("lost");
		
		assertNotNull(book);
	
	}
	
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByAuthornameWhchDoesNotExist()
	{
		Book book = lib.getCatalogue().searchBook("Chetan");
		
		assertNull(book);
	
	}
	
	

	
	
	
	@Test(groups = {"Alltests","basicOperation"})
	public void testAddToLibraryWithSupportedObject()
	{
		int initialSize = lib.getCatalogue().getCatalougeSize();
		try
		{
			lib.getCatalogue().addToLibrary(new Book(5, "Mahabhartha", "VedVyas"));
		}catch(Exception e)
		{
			// not expecting any exception
		}
		
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize + 1);
		
	}
	
	
	@Test(groups = {"Alltests"}, expectedExceptions = LibraryObject.class)
	public void testAddToLibraryWithUnsupportedObject() throws Exception
	{
		lib.getCatalogue().addToLibrary("New Video");
			
	}
	
	
	/**
	 * test is dependent on testCatalogueAddBook method.
	 * if dependency is not added testcase will fail.
	 */
	@Test(groups = {"Alltests"}, dependsOnMethods = {"testCatalogueAddBook"})
	public void testARemoveNewlyAddedBook()
	{
		int initialSize = lib.getCatalogue().getCatalougeSize();
				
		lib.getCatalogue().removeBook(4);
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize - 1);
		
	}
	
	
	/**
	 * test is dependent on basic Operation group.
	 * if dependency is not added testcase will fail.
	 */
	@Test(groups = {"Alltests"}, dependsOnGroups = {"basicOperation"})
	public void testARemoveNewlyAddedBook2()
	{
		int initialSize = lib.getCatalogue().getCatalougeSize();
				
		lib.getCatalogue().removeBook(5);
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize - 1);
		
	}

	
	
	@Test(groups = {"basicOperation","Alltests"}, dataProvider = "BookNames")
	public void testCatalogueAddBooks(int bookID,String bookName, String authorName)
	{
		System.out.println("Calling test add Books for : " + bookName);
		int initialSize = lib.getCatalogue().getCatalougeSize();
		lib.getCatalogue().addBook(new Book(bookID, bookName, authorName));
		
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize + 1);
		
	}
	
	@Test(groups = {"basicOperation","Alltests"}, dataProvider = "BookNamesV2")
	public void testCatalogueAddBooks(Book book)
	{
		int initialSize = lib.getCatalogue().getCatalougeSize();
		lib.getCatalogue().addBook(book);
		
		assertEquals(lib.getCatalogue().getCatalougeSize(), initialSize + 1);
		
	}
	
	
	@Test(groups = {"Alltests"})
	@Parameters("searchStr")
	public void testCatalogueSearchByBookNamePara(String searchStr)
	{
		Book book = lib.getCatalogue().searchBook(searchStr);
		assertNotNull(book);
	
	}
	
	@DataProvider(name = "BookNames")
	public static Object[][] bookNames()
	{
		return new Object[][] {
			{6,"Harry Potter","J K Rowling"},
			{7,"wings of Fire","APJ Kalam"},
			{8,"Believe","Suresh Raina"},
			{9,"Psycology of Money","Morgan"},
			{10,"Rich Dad Poor Dad","Robert"},
			{11,"Zero to One","Peter"},
			{12,"Arthshashtra","Kautilaya"},
			{13,"×›× ×¤×™ ××©","×§××•×˜×™×œ×™×”"},
			{14,"ã‚«ã‚¦ãƒ†ã‚£ãƒ©ãƒ¤","ã‚«ã‚¦ãƒ†ã‚£ãƒ©ãƒ¤"},
			{15,"è€ƒææ‹‰äºž","è€ƒææ‹‰äºž"}
			
		};
	}
	
	
	@DataProvider(name = "BookNamesV2")
	public static Object[][] bookNamesVer2()
	{
		return new Object[][] {{
			new Book(7,"wings of Fire","APJ Kalam")
		}
		};
	}
	
	
	
	
	
	
	
}
