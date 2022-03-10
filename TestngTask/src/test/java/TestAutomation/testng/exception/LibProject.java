package TestAutomation.testng.exception;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import epam.com.TestngTask.MemberClass;

public class LibProject {

	public ArrayList<MemberClass> list;

	LibProject() {
		list = new ArrayList<>();

	}

	public void AddMember(MemberClass mem) {

		list.add(mem);
	}

	public int getofSize() {
		return list.size();
	}
}
