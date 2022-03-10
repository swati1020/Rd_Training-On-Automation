package epam.com.DatabaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FunctionTesting {

	Connection conn;
	ResultSet resultSet;
	ResultSet resultSet1;
	Statement stmt;

	@BeforeTest
	public void setup() throws ClassNotFoundException, SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "swati");

	}
	
	@Test
	void test_procedureFunctionISExist() throws SQLException {
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("Show function status where db ='classicmodels'");
		resultSet.next();
		Assert.assertEquals(resultSet.getString("name"), "customerlevel");
		
	}
	
	@Test
	void test_CustomerLevelSql() throws SQLException {
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("select customerName, customerlevel(creditLimit) from customers");
		resultSet1=stmt.executeQuery("select customerName, \r\n"
				+ "case when  credit > 50000 then\r\n"
				+ "'platinum'\r\n"
				+ "when creditlimit >= 10000 and \r\n"
				+ "creditlimit < 50000 then 'gold'\r\n"
				+ "when creditlimit <10000 then\r\n"
				+ "'silver'\r\n"
				+ "end as customerlevel from\r\n"
				+ "customers;");
		resultSet.next();
		Assert.assertEquals(compareResultSets(resultSet,resultSet1),true);
		

	}
	public boolean compareResultSets(ResultSet resultSet1,ResultSet resultSet2) throws SQLException {
		while(resultSet1.next()) {
			resultSet2.next();
			int count= resultSet1.getMetaData().getColumnCount();
		 for(int i=1;i<= count;i++) {
			 if(!StringUtils.equals(resultSet1.getString(i), resultSet2.getString(i))) {
				 return false;
			 }
		 }
		}
		return true;
	}
	
	
	@AfterClass
	public void tearDown() throws SQLException {
		conn.close();
	}
}
