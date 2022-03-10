package epam.com.SelfPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DatabaseTestingPractice {
	Connection conn= null;
	
	@BeforeClass
	public void setUp() throws SQLException {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","swati");
		
	}
	
	@AfterClass
	public void tearDown() throws SQLException {
		conn.close();
	}

}
