package epam.com.RestAssured;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.*;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;



@Test
public class ApiAssignment {
	
	public static String token;
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI="http://restapi.adequateshop.com";
	}
	@Test
	public static void testPostObjectGETResponse() {
		given()
		.when()
		.get("http://restapi.adequateshop.com")
		.then()
		.statusCode(200);
	}
	
	@Test
	public static void testPostObjectResigtrator() {
//		String str="http://restapi.adequateshop.com/api/authaccount/registration";
		
		String registration="{\r\n"
				+ "    \"name\": \"Swati\",\r\n"
				+ "    \"email\":\"1234@gmail.com\",\r\n"
				+ "    \"password\":123456\r\n"
				+ "\r\n"
				+ "}";
			    		
             given()
             .header("Content-type","application/json")
              .and()
             .body(registration) 
           .when()//Execute
             .post("http://restapi.adequateshop.com/api/authaccount/registration")
             .then()// verification
            .statusCode(200);
	}
	
	@Test
	public static void testPostObjectLogin() {
		String str="http://restapi.adequateshop.com/api/authaccount/Login";
		String login="{\r\n"
				+ "    \"email\":\"123@gmail.com\",\r\n"
				+ "    \"password\": 123456\r\n"
				+ "}";
			    		
             given()
             .header("Content-type","application/json")
              .and()
             .body(login) 
           .when()//Execute
             .post("http://restapi.adequateshop.com/api/authaccount/login")
             .then()// verification
            .statusCode(200);
	}
	
	@Test
	public static void noUnauthenticationUserGetData() {
		String url="http://restapi.adequateshop.com/api/users?page=1";
		token="46704a72-4992-4c6c-8f09-bc21e71af35e";
		 given()
//        .header("authorization", "bearer 46704a72-4992-4c6c-8f09-bc21e71af35e")
		 .header("authorization", token)
		 .when()//Execute
		 .get(url)
		 .then()//Verification
		  .statusCode(401);
		
	}
	@Test
	public static void testAuthenticationUserData() {
		String userUrl="http://restapi.adequateshop.com/api/users?page=1";
		given()
		.header("authorization", "bearer"+ token)
		.when()
		.get(userUrl)
		.then()
		.statusCode(200)
		.body("page", equalTo(1));
		
	
	}
}

