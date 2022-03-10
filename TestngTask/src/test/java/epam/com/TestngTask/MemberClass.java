package epam.com.TestngTask;

import java.awt.print.Book;
import java.util.ArrayList;


public class MemberClass {
	
	int MemberID;
	String FirstName;
	String LastName;
	String City;
	int Age;
	public Boolean Status;
	public ArrayList<Integer> issuedBookList;
	

  public MemberClass(int MemberID, String Firstname, String Lastname,String City, int Age, Boolean Status) {
		this.MemberID = MemberID;
		this.FirstName = Firstname;
		this.LastName = Lastname;
		this.City = City;
		this.Age = Age;
		this.Status = Status;
		this.issuedBookList= new ArrayList<>();//empty
		
	}
	

	public void deactivateUser() {
		this.Status = false;

	}

	public void activateUser() {
		this.Status = true;

	}

	public void IssuedBook(int bookId) {
		this.issuedBookList.add(bookId);

	}

	public int getMemberID() {
		return MemberID;
	}

	public void setMemberID(int memberID) {
		this.MemberID = memberID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public ArrayList<Integer> getIssuedBookList(int id) {
		return issuedBookList;
	}


}
