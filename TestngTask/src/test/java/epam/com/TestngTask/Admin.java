package epam.com.TestngTask;

import TestAutomation.testng.exception.BookDoesNotExist;
import TestAutomation.testng.exception.MemberDoesNotExist;
import TestAutomation.testng.exception.MemberIsInactive;

public class Admin {
	
	private Library lib;
	
	public Admin(Library lib) {
		this.lib = lib;
	}

	public void assignBookToMember(int bookID, int memberID) 
			throws MemberDoesNotExist,MemberIsInactive,BookDoesNotExist
	{
		Member member = this.lib.findMemberById(memberID);
		if(member == null)
		{
			throw new MemberDoesNotExist("Member with given id does not exist");
		}
		if(member.getStatus() == MemberStatus.INACTIVE)
		{
			throw new MemberIsInactive("Operation not allowed for inactive Member");
		}
		
		
		
		Book book = this.lib.getCatalouge().findBookById(bookID);
		if(book == null)
		{
			throw new BookDoesNotExist("Book with given id does not exist");
		}
		
		member.issueBook(book);
		
		
	}
}
