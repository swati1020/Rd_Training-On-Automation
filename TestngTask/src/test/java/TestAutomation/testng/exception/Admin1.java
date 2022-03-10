package TestAutomation.testng.exception;

import java.util.ArrayList;
import java.util.Iterator;

import epam.com.TestngTask.MemberClass;

public class Admin1 {

	public void issueBookToMember(int MemberID, int BookID) {
		LibProject p = new LibProject();
		for (MemberClass obj : p.list) {
			if (obj.getMemberID() == MemberID && obj.Status) {// checking the member id and status is true
				obj.issuedBookList.add(BookID);
			}

		}

	}

	   
}
	
	




