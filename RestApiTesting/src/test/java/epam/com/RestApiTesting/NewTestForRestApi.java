package epam.com.RestApiTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class NewTestForRestApi {
	  String id;
	  String punchIn;
//	static String token="d1e713ed8bd99ed742ef49734ccf6b4ab4398f8e";
//	static String cookies="orangehrmSecurityAuthentication_LoginLocationTracker=e3afed0047b08059d0fada10f400c1e5; orangehrm=b67bec199594ecb0307ace07f31d9b87; navigation_log_latest_url=%2Fauth%2Flogin";
	  String token="6fee2fbfa2d8a082d886d65e0dbb5c57d49930ab";
	  String cookies="orangehrmSecurityAuthentication_LoginLocationTracker=e3afed0047b08059d0fada10f400c1e5; orangehrm=846b75fba4d26b990d3fa5dcf9370a97; navigation_log_latest_url=%2Fauth%2Flogin";
	  @BeforeClass
	public void setup(ITestContext context) throws MalformedURLException
	{
	this.token=context.getCurrentXmlTest().getParameter("token");
	this.cookies=context.getCurrentXmlTest().getParameter("cookies");
	RestAssured.baseURI="https://prasoonr-trials73.orangehrmlive.com/";
	}
	
	

	@Test(priority=1)
	public void testAuthenticationUser() {
        id=given()
       .header("Authorization", "Bearer "+ token)
		.and()
		.header("Cookie",cookies)
		.and()
		.header("Content-type","application/x-www-form-urlencoded")
		.when()
		.get("api/attendanceSheet")
		.then()
		.statusCode(200)
		.extract().jsonPath().getString("data.latestSheetId");
       assertNotNull(id);
		
	}
	@Test(priority=2)
	public  void testAttendanceWithID() 
	{
			Response response = given()
				.header("Authorization","Bearer "+token)
				.and()
				.header("Content-Type","application/x-www-form-urlencoded")
				.and()
				.header("cookie",cookies)
				.when()
				.get("/api/attendanceSheet?id=" + id)
				.then()
				.statusCode(200)
				.extract().response();
			String result=response.asString();
			System.out.println(result);	
	}
	@Test(priority=3)
	public void testGetResponseForAttendanceConfig() {
	Response res=given()
	.log()
	.all()
	.header("Authorization", "Bearer " + token)
	.and()
	.header("Content-type", "application/x-www-form-urlencoded")
	.and()
	.header("Cookie", cookies)
	.when()
	.get("api/attendance/config")
	.then()
	.statusCode(200)
	.extract().response();
	String response = res.asString();
	System.out.println(response);

	}

	
	@Test(priority=4)
	public void testPostResponseForAttendanceRecordsPunchIn() {
		PojoForRestApiTesting punchInbody= new PojoForRestApiTesting();
		punchInbody.setEmpName(13);
		punchInbody.setDate("2022-03-07");
		punchInbody.setTime("09:00");
		punchInbody.setForcePunchIn(false);
		 punchIn= given()
		.header("Authorization", "Bearer "+ token)
		.and()
		.header("Content-type","application/json")
		.and()
		.header("Cookie",cookies)
		.body(punchInbody)
		.when()
		.post("api/attendanceRecords")
		.then()
	     .extract().jsonPath().getString("data.id");
		System.out.println("message is "+punchIn);
		assertNotNull(punchIn);
	
	}
	
	@Test(priority=5)
	public void testPostResponseForAttendanceRecordsPunchInAgain() {
		PojoForRestApiTesting punchInbody= new PojoForRestApiTesting();
		punchInbody.setEmpName(13);
		punchInbody.setDate("2022-03-07");
		punchInbody.setTime("09:00");
		punchInbody.setForcePunchIn(false);
	   
			 given()
			.header("Authorization", "Bearer "+ token)
			.and()
			.header("Content-type","application/json")
			.and()
			.header("Cookie",cookies)
			.body(punchInbody)
			.when()
			.post("api/attendanceRecords")
			.then()
//		     .extract().jsonPath().getString("data.id");
//			System.out.println("message is "+punchIn);
//			assertNotNull(punchIn);
			.statusCode(403);
		
		}
	
	@Test(priority=6)
	
	    public void testingPunchOut(){
		PojoForRestApiTesting punchOut= new PojoForRestApiTesting();
		punchOut.setEmpName(13);
		punchOut.setDate("2022-03-07");
		punchOut.setTime("13:21");
		punchOut.setTimezoneOffset("5.5");

      Boolean message=given()
	.header("Authorization","Bearer "+token)
	.and()
	.header("Content-Type","application/json")
	.and()
	.header("Cookie",cookies)
	.and()
	.body(punchOut)
	 .when()
	 .patch("api/attendanceRecord/"+ punchIn)
//	.prettyPrint();
	  .then()
	 .statusCode(200)
	 .extract().jsonPath().getBoolean("success");
	  assertTrue(message);
	

	}
	
	@Test(priority=7)
	public void punchINAgainWithSameTimeWithoutPunchOut() {
		PojoForRestApiTesting punchInbodyAgain= new PojoForRestApiTesting();
		punchInbodyAgain.setEmpName(13);
		punchInbodyAgain.setDate("2022-03-07");
		punchInbodyAgain.setTime("09:00");
		punchInbodyAgain.setForcePunchIn(false);
		Response res=given()
		.header("Authorization","Bearer "+token)
		.and()
		.header("Cookie",cookies)
		.and()
		.header("Content-type","application/json")
		.body(punchInbodyAgain)
		.when()
		.post("/api/attendanceRecords")
		.then()
		.statusCode(403)
		.extract().response();
		assertEquals(res.asString(),"Unauthorized");
		System.out.println("Response is: "+res.asString());
		}

	
	@Test(priority=8)
	public void testforResponseWithTime() {
		String totaltime=given()
		.header("Authorization", "Bearer "+ token)
		.and()
		.header("Cookie",cookies)
		.when()
		.get("api/attendanceSheet?id="+ id)
		.then()
		.statusCode(200)
		.extract().response().jsonPath().getString("meta.totals.T.duration");
		assertNotNull(totaltime);
		System.out.print(totaltime);
}

	
	@Test(priority=9)
	public void testDeleteExistingRecords() {
	String id="{\r\n"
			+ "  \"id\": [\r\n"
			+ punchIn +"\r\n" 
			+ "  ]\r\n"
			+ "}";
		
	String Expectedresult=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookies).and()
	.header("Content-type","application/json")
	.body(id)
	.when()
	.delete("/api/attendanceRecords")
	.then()
	.statusCode(200)
	.extract().jsonPath().getString("messages.success");
	System.out.println("message is "+Expectedresult);
	assertEquals(Expectedresult,"Successfully Deleted");
	}
	
	
}
