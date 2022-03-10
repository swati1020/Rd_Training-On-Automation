package epam.com.TestngTask;


import java.util.ArrayList;
import java.util.Iterator;

public class Library {

	private CatalogueClass catalouge;
	private Admin admin;
	private ArrayList<Member> members;
	
	public Library() {
		this.members = new ArrayList<Member>();

	}
	
	public CatalogueClass getCatalouge() {
		return catalouge;
	}
	public void setCatalouge(CatalogueClass catalouge) {
		this.catalouge = catalouge;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public ArrayList<Member> getMembers() {
		return members;
	}
	public void setMember(ArrayList<Member> members) {
		this.members = members;
	}
	
	public void addMember(Member member) {
		this.members.add(member);
	}
	
	public Member findMemberById(int id)
	{
		for (Iterator iterator = members.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			if(member.getMemberID() == id)
			{
				return member;
			}
		}
		
		return null;
	}
	
	
	
}

