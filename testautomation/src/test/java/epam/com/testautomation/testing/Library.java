package epam.com.testautomation.testing;

import java.util.ArrayList;

public class Library {
	private Catalogue catalogue;
	private Admin admin;
	private ArrayList<Member> members;
	public Catalogue getcatalogue() {
	return catalogue;
	
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
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
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
}
