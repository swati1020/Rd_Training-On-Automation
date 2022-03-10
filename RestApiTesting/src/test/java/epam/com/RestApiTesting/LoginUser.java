//package epam.com.RestApiTesting;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.testng.Assert.assertEquals;
//
//import java.net.MalformedURLException;
//
//import org.testng.ITestContext;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import io.restassured.RestAssured;
//import io.restassured.response.ValidatableResponse;
//
//public class LoginUser {
//	
//	static String token;
//	static String cookies;
//// static	String token= "b268c313beb9aa23fc4c3aaeccdfb7b7d39a5798";
//// static String cookies="orangehrmSecurityAuthentication_LoginLocationTracker=e3afed0047b08059d0fada10f400c1e5; orangehrm=a41c0b6ec4b603e10093724a3b63d18e; navigation_log_latest_url=%2Fauth%2Flogin";
//	@BeforeClass
//	
//	public void setup(ITestContext context) throws MalformedURLException
//	{
//	this.token=context.getCurrentXmlTest().getParameter("token");
//	this.cookies=context.getCurrentXmlTest().getParameter("cookies");
//	RestAssured.baseURI="https://prasoonr-trials73.orangehrmlive.com/";
//	}
//	
//	
//
//	@Test
//	public static void testAuthenticationUserData1() {
//
//		given()
//		.header("Authorization", "Bearer "+ token)
//		.and()
//		.header("Cookie",cookies)
//		.when()
//		.get("api/attendanceSheet")
//		.then()
//		.statusCode(200);
//		
//	}
//	@Test(priority=1)
//	public static void testforResponseId() {
//		given()
//		.header("Authorization", "Bearer "+ token)
//		.and()
//		.header("Cookie",cookies)
//		.when()
//		.get("api/attendanceSheet?id=653")
//		.then()
//		.statusCode(200)
//		.body("data[0].total", equalTo(14460));
//		
//	}
//	@Test(priority=1)
//	public static void testforResponseWithTime() {
//		given()
//		.header("Authorization", "Bearer "+ token)
//		.and()
//		.header("Cookie",cookies)
//		.when()
//		.get("api/attendanceSheet?id=653")
//		.then()
//		.statusCode(200)
//		.extract().response().jsonPath().getString("meta.totals.T.duration");
//        
//		
//	}
//	@Test(priority=2)
//	public static void testResponseForAttendance() {
//
//		given()
//		.header("Authorization", "Bearer "+ token)
//		.and()
//		.header("Content-type", "application/json")
//		.when()
//		.get("api/attendance/config")
//		.then()
//		.statusCode(200);
//		
//	}
//	@Test(priority=3)
//	public static void testPostResponseForAttendanceRecordsPunchIn(Object status) {
//		
//		//using with pojo
//		
//		PojoForRestApiTesting punchOutWithInValidTime = new PojoForRestApiTesting(13,"2022-03-08","14:25","5.5");
////		PojoForRestApiTesting punchOutWithInValidTime = new PojoForRestApiTesting();
////		punchOutWithInValidTime.setEmpNumber(13);
//
////    String punchInbody= "{\r\n"
////    		+ "  \"empNumber\": \"13\",\r\n"
////    		+ "  \"mode\": \"checkPunchInOverlappingRecords\",\r\n"
////    		+ "  \"punchInDate\": \"2022-03-08\",\r\n"
////    		+ "  \"punchInTime\": \"14:25\",\r\n"
////    		+ "  \"punchInTimezoneOffset\": \"5.5\"\r\n"
////    		+ "}";
//    
//		//by using obj
////    pojoObj.setEmpNumber(13);
////    pojoObj.setDate("2022-03-08");
////    pojoObj.setTime("14:25");
////    pojoObj.setTimezoneOffset("5.5");
//   
//		
//	  given()
//		.header("Authorization", "Bearer "+ token)
//		.and()
//		.header("Content-type","application/json")
//		.and()
//		.header("Cookie",cookies)
//		.body(punchOutWithInValidTime)
//		.when()
//		.post("api/attendanceRecords")
//		.then()
//		.statusCode(200);
//		assertEquals(status,"In");
//	}
//	@Test(priority=4)
//	public static void testPostResponseForPunchOut() {
////	    String punchOutbody= "{\r\n"
////	    		+ "  \"empNumber\": \"13\",\r\n"
////	    		+ "  \"mode\": \"checkPunchOutOverlappingRecords\",\r\n"
////	    		+ "  \"id\": \"30020\",\r\n"
////	    		+ "  \"punchInDate\": \"2022-03-17\",\r\n"
////	    		+ "  \"punchOutDate\": \"2022-03-17\",\r\n"
////	    		+ "  \"punchInTime\": \"20:47\",\r\n"
////	    		+ "  \"punchInTimezoneOffset\": \"5.5\",\r\n"
////	    		+ "  \"punchOutTime\": \"14:47\",\r\n"
////	    		+ "  \"punchOutTimezoneOffset\": \"5.5\"\r\n"
////	    		+ "}";
//	    
//	    PojoForRestApiTesting punchOutbody = new PojoForRestApiTesting(13,30020,"2022-03-17","2022-03-17","20:47","5.5","14:47","5.5");
//			  given()
//			.header("Authorization", "Bearer "+ token)
//			.and()
//			.header("Content-type","application/json")
//			.and()
//			.header("Cookie",cookies)
//			.body(punchOutbody)
//			.when()
//			.post("api/attendanceRecords")
//			.then()
//			.statusCode(200);
//			
//		}
//	
//
//	@Test(priority=5)
//	public static void testPostResponseForPunchOutIssueToken() {
//	    String issuedTokenbody= "{\r\n"
//	    		+ "  \"grant_type\": \"refresh_token\",\r\n"
//	    		+ "  \"client_id\": \"public_rest_api_client\",\r\n"
//	    		+ "  \"client_secret\": \"\",\r\n"
//	    		+ "  \"refresh_token\": \"f6eb52156f51861fb26daacf7fb39bcfd16e2859\"\r\n"
//	    		+ "}";
//			  given()
//			.header("Authorization", "Bearer "+ token)
//			.and()
//			.header("Content-type","application/json")
//			.and()
//			.header("Cookie",cookies)
//			.body(issuedTokenbody)
//			.when()
//			.post("oauth/issueToken")
//			.then()
//			.statusCode(400);
//			
//		}
//	@Test(priority=6)
//	    public static void testNavigationLog() {
//		String navigate="{\r\n"
//				+ "  \"from\": \"/auth/login\",\r\n"
//				+ "  \"to\": \"/dashboard\",\r\n"
//				+ "  \"time\": \"2022-03-08 13:26:39\",\r\n"
//				+ "  \"current_menu\": \"More > Dashboard\",\r\n"
//				+ "  \"clickedOn\": \"other\"\r\n"
//				+ "}";
//		  given()
//			.header("Authorization", "Bearer "+ token)
//			.and()
//			.header("Content-type","application/json")
//			.and()
//			.header("Cookie",cookies)
//			.body(navigate)
//			.when()
//			.get("api/navigationLog")
//			.then()
//			.statusCode(200);
//		
//		
//	}
//	@Test(priority=7)
//	public void testDeleteExistingRecords() {
//	String id="{\"ids\":[\"30210\"]}";
//	String Expectedresult=given()
//	.header("Authorization","Bearer "+token).and()
//	.header("Cookie",cookies).and()
//	.header("Content-type","application/json")
//	.body(id)
//	.when()
//	.delete("/api/attendanceRecords")
//	.then()
//	.statusCode(200)
//	.extract().jsonPath().getString("messages.success");
//	System.out.println("message is "+Expectedresult);
//	assertEquals(Expectedresult,"Successfully Deleted");
//	}
//	
//	@Test(priority=8, enabled= false)
//	public static void testPostResponseForPunchOutWithInValidTime() {
//		PojoForRestApiTesting punchOutWithInValidTime = new PojoForRestApiTesting();
//		punchOutWithInValidTime.setEmpNumber(13);
//		punchOutWithInValidTime.setId(30020);
//		punchOutWithInValidTime.setPunchInDate("2022-03-17");
//		punchOutWithInValidTime.setPunchOutDate("2022-03-17");
//		punchOutWithInValidTime.setPunchInTime("20:47");
//		punchOutWithInValidTime.setPunchOutDate("18:20");
//		punchOutWithInValidTime.setPunchInTimezoneOffset("5.5");
////	    String punchOutbody= "{\r\n"
////	    		+ "  \"empNumber\": \"13\",\r\n"
////	    		+ "  \"mode\": \"checkPunchOutOverlappingRecords\",\r\n"
////	    		+ "  \"id\": \"30020\",\r\n"
////	    		+ "  \"punchInDate\": \"2022-03-17\",\r\n"
////	    		+ "  \"punchOutDate\": \"2022-03-17\",\r\n"
////	    		+ "  \"punchInTime\": \"20:47\",\r\n"
////	    		+ "  \"punchInTimezoneOffset\": \"5.5\",\r\n"
////	    		+ "  \"punchOutTime\": \"11:47\",\r\n"
////	    		+ "  \"punchOutTimezoneOffset\": \"5.5\"\r\n"
////	    		+ "}";
//			  ValidatableResponse res =given()
//			.header("Authorization", "Bearer "+ token)
//			.and()
//			.header("Content-type","application/json")
//			.and()
//			.header("Cookie",cookies)
//			.body(punchOutWithInValidTime)
//			.when()
//			.post("api/attendanceRecords")
//			.then()
//			.statusCode(400);
//			  assertEquals(res,"issued token");
//		}
//	
//}
