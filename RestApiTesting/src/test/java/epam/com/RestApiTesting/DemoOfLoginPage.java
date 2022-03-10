package epam.com.RestApiTesting;

//public class DemoOfLoginPage {
//
//}
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DemoOfLoginPage {
 static	String token= "f6eb52156f51861fb26daacf7fb39bcfd16e2859";
 static String cookies="orangehrmSecurityAuthentication_LoginLocationTracker=e3afed0047b08059d0fada10f400c1e5; orangehrm=1bbb63a11afeaf2e71e25423a9479255; navigation_log_latest_url=%2Fauth%2Flogin";
// static String cookies="orangehrmSecurityAuthentication_LoginLocationTracker=e3afed0047b08059d0fada10f400c1e5; orangehrm=50f9899fe0d3e07784ab6cf9890b06ce; navigation_log_latest_url=%2Fauth%2Flogin";

 @BeforeTest
	public static void setup() {
		RestAssured.baseURI="https://prasoonr-trials73.orangehrmlive.com/";
	}
   @Test
	public static void testPostObjectResigtrator() {
//		token="4e68b0f33eed7295c72bd1ef2d9ae9c61c5bd8ca";
		String registration= "{txtUsername: Admin\r\n"
				+ "txtPassword: U@qBLVtm09}";
			    		
             given()
             .header("Content-type","application/x-www-form-urlencoded")
           .when()//Execute
          .post("https://prasoonr-trials73.orangehrmlive.com/auth/login") 
             .then()// verification
            .statusCode(200);
	}
	@Test
	public static void testAuthenticationUserData() {
		
		String userUrl="https://prasoonr-trials73.orangehrmlive.com/auth/validateCredentials";
		given()
		.header("Authorization", "Bearer "+ token)
		.and()
		.header("Cookie",cookies)
		.when()
//		.get("api/attendanceSheet")
		.get(userUrl)
		.then()
		.statusCode(200);
		
	}
	@Test
	public static void testPostResponseForAttendanceRecords() {
	    String punchInbody= "{\r\n"
	    		+ "  \"empNumber\": \"13\",\r\n"
	    		+ "  \"mode\": \"checkPunchInOverlappingRecords\",\r\n"
	    		+ "  \"punchInDate\": \"2022-03-08\",\r\n"
	    		+ "  \"punchInTime\": \"14:25\",\r\n"
	    		+ "  \"punchInTimezoneOffset\": \"5.5\"\r\n"
	    		+ "}";
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
			.statusCode(200);
			
		}
		@Test
		public static void testPostResponseForPunchOut() {
		    String punchOutbody= "{\r\n"
		    		+ "  \"empNumber\": \"13\",\r\n"
		    		+ "  \"mode\": \"checkPunchOutOverlappingRecords\",\r\n"
		    		+ "  \"id\": \"30020\",\r\n"
		    		+ "  \"punchInDate\": \"2022-03-17\",\r\n"
		    		+ "  \"punchOutDate\": \"2022-03-17\",\r\n"
		    		+ "  \"punchInTime\": \"20:47\",\r\n"
		    		+ "  \"punchInTimezoneOffset\": \"5.5\",\r\n"
		    		+ "  \"punchOutTime\": \"14:47\",\r\n"
		    		+ "  \"punchOutTimezoneOffset\": \"5.5\"\r\n"
		    		+ "}";
				  given()
				.header("Authorization", "Bearer "+ token)
				.and()
				.header("Content-type","application/json")
				.and()
				.header("Cookie",cookies)
				.body(punchOutbody)
				.when()
				.post("api/attendanceRecords")
				.then()
				.statusCode(201);
				
			}
	
}
