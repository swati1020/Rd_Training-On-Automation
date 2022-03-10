package epam.com.DatabaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.sql.CallableStatement;

import org.apache.commons.codec.binary.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStoredProcedure {
	Connection con;
	ResultSet resultSet;
	Statement st;

	@BeforeTest
	public void setup() throws ClassNotFoundException, SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "swati");

	}

	@Test
	public void testExistOrNot() throws SQLException {
		String sqltables[] = { "city", "citywithdetails", "country", "countrylanguage", "employee" };
		ArrayList<String> table = new ArrayList<String>();
		st = con.createStatement();
		resultSet = st.executeQuery("show tables");
		int index = 0;
		while(resultSet.next()) {
		String tablename = resultSet.getString(1);
		table.add(tablename);
//		assertEquals(sqltables[index], tablename);
		}
		assertTrue(table.contains("country"));
//			index++;

	}

	@Test
	public void checkingColumnNames() throws SQLException {
		String columnnames[] = { "city", "city_id", "country_id", "last_update", "countrycode", "district", "id",
				"name", "population" };
		st = con.createStatement();
		resultSet = st.executeQuery("select column_name from information_schema.columns where table_name='city';");
		int index = 0;
		int flag = 0;
		while (resultSet.next()) {
			flag = 1;
			String colname = resultSet.getString(1);// col val
			assertTrue(columnnames[index].equalsIgnoreCase(colname));
			index++;
		}
		assertEquals(1, flag);
	}

	@Test
	public void checkingColumnAndDataType() throws SQLException {
		String datatypes[] = { "varchar", "smallint", "smallint", "timestamp", "char", "char", "int", "char", "int" };
		st = con.createStatement();
		resultSet = st.executeQuery("select column_name,data_type from information_schema.columns where table_name='city'");
		int index = 0;
		while (resultSet.next()) {
			String datatypename = resultSet.getString(2);
			assertTrue(datatypes[index].equalsIgnoreCase(datatypename));
			index++;
		}
	}

	@Test
	public void columnsCount() throws SQLException {
		st = con.createStatement();
		resultSet = st.executeQuery("select count(*) from information_schema.columns where table_name='city';");
		resultSet.next();
		assertEquals("9", resultSet.getString(1));

	}

	@Test
	public void nullablevalue() throws SQLException {
		st = con.createStatement();
		resultSet = st
				.executeQuery("select column_name,is_nullable from information_schema.columns where table_name='city'");
		resultSet.next();
		assertEquals("NO", resultSet.getString(2));
	}

	@Test
	public void maximunLengthTest() throws SQLException {
		String[] columnNames = { "CountryCode", "District", "ID", "Name", "Population" };
		String[] dataTypesLength = { "3", "20", null, "35", null };
		boolean flag = false;
		Statement statement = con.createStatement();
		String query = "select Column_Name,character_maximum_length from Information_Schema.columns where table_schema='world' and table_name='city';";
		ResultSet result = statement.executeQuery(query);
		int index = 0;
		while (result.next()) {
			flag = true;
			String dataTypeLength = result.getString(2);
			assertEquals(dataTypeLength, dataTypesLength[index]);
			index++;
		}
		assertTrue(true);
	}

	@Test
	public void testRightKeys() throws SQLException {
		int index = 0;
		String keys[] = { " ", "PRI", "MUL", "", "MUL", "", "PRI", "", "" };
		resultSet = st
				.executeQuery("select column_name,column_key from information_schema.columns where table_name='city'");
		while (resultSet.next()) {
			assertTrue(keys[index].equalsIgnoreCase(resultSet.getString(2)));
			index++;
		}

	}

	@Test(enabled = false)
	public void testStoredProcedureExistence() throws SQLException {
		st = con.createStatement();
		resultSet = st.executeQuery("show procedure status where name ='addcityTocityList'");

		resultSet.next();

		String procedureName = resultSet.getString("name");
		assertEquals(procedureName, "addcityTocityList");
//		}
	}

	@AfterClass
	public void tearDown() throws SQLException {
		con.close();
	}

	@Test(enabled = false)
	public void testByCityDetails() throws SQLException {

		CallableStatement cstmt = con.prepareCall("{CALL `cityDetails`}");
		resultSet = cstmt.executeQuery();

//	int indexName= resultSet.findColumn("name");
//	int indexDistrict= resultSet.findColumn("district");
//	int indexPopulation= resultSet.findColumn("name");
//	int indexCountry= resultSet.findColumn("countryCode");
		st = con.createStatement();
		ResultSet actualData = st.executeQuery("Select * from city");
		assertTrue(compareResultSet(resultSet, actualData));

	}

	@Test(enabled = false)
	public void testByCountry() throws SQLException {
		CallableStatement cstmt = con.prepareCall("{CALL cityByCountry(?)}");

		cstmt.setString(1, "AFG");
		resultSet = cstmt.executeQuery();

		st = con.createStatement();
		ResultSet actualData = st.executeQuery("Select * from city where countryCode='AFG'");
		assertTrue(compareResultSet(resultSet, actualData));
	}

	@Test(enabled = false)
	public void test_storedProduresExists() throws SQLException {
		st = con.createStatement();
		resultSet = st.executeQuery("show procedure status where name ='addcityToCityList'");
		resultSet.next();
		st = con.createStatement();
		ResultSet actualData = st.executeQuery("Select * from city where name='addcityToCityList'");
		assertTrue(compareResultSet(resultSet, actualData));
	}

	@Test(enabled = false)
	public void numberofcolumnsInACity() throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(
				"select count(*) as NumberoFColumns from Information_Schema.columns where table_schema='world' and table_name='city'");
		int count = 0;
		while (result.next()) {

			count = result.getInt("NumberoFColumns");
		}
		assertEquals(count, 5);

	}

	@Test(enabled = false)
	public void testForTrigger() throws SQLException {
		Statement statement = con.createStatement();
		String id = "10";
		String query = "Insert into employee(id,name,age,city)" + "values(10,'aman',31,'ggn')";
		statement.execute(query);

		String query1 = "select * from employee where id=" + id;
		ResultSet result = statement.executeQuery(query1);
		String language = "";
		while (result.next()) {
			language = result.getString("language");

		}

		assertEquals(language, "hindi");

	}

//	
	@Test
	public void testProducerCityCountByCountry() throws SQLException {

		CallableStatement call = con.prepareCall("{call cityCountsByCountry(?,?,?)}");
		call.setString(1, "AFG");
		call.registerOutParameter(2, Types.INTEGER);
		call.registerOutParameter(3, Types.INTEGER);
		call.executeQuery();

		int cityCount = call.getInt(2);
		int countryCount = call.getInt(3);

		Statement statement = con.createStatement();

		ResultSet actualCityresult = statement.executeQuery("Select count(*) from city where countrycode='AFG'");
		actualCityresult.next();
		int expectedCityCount = actualCityresult.getInt(1);

		ResultSet actualCountryresult = statement.executeQuery("Select count(*) from country");
		actualCountryresult.next();
		int expectedCountryCount = actualCountryresult.getInt(1);

		assertEquals(cityCount, expectedCityCount);
		assertEquals(countryCount, expectedCountryCount);

	}

	@Test(enabled = false)
	public boolean compareResultSet(ResultSet rs1, ResultSet rs2) throws SQLException {
		try {
			while (rs1.next()) {
				rs2.next();
				int count = rs1.getMetaData().getColumnCount();
				for (int i = 1; i <= count; i++) {
					if (!rs1.getString(i).equals(rs2.getString(i))) {
						return false;
					}
				}
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
