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
public class TestPost {
	@Test
	public static void testPostObjectGETResponse() {
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.statusCode(200);
	}
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	}

	
	@Test
		public static void testPostObjectGETId() {
			given().pathParam("id","1")
			.when()
			.get("https://jsonplaceholder.typicode.com/posts/{id}")
			.then()
			.statusCode(200)
			.body("userId",equalTo(1));
		}
	@Test
	public static void testPostObjectParam() {
//		given().queryParam("Userid", 1)
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/?userId=1")
		.then()
		.statusCode(200)
		.body("[0].userId",equalTo(1));
		
	}
	@Test(dataProvider= "userID")
	public static void testPostObjectGETResponseWithParamSearch(int UserID,int id) {
		List<Object> posts =given().queryParam("Userid", UserID)
		.queryParam("userId", UserID)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/")
		.then()//verification
		.statusCode(200)
		.body("[0].userId",equalTo(UserID))
		.extract().jsonPath().getList("$");
	AssertJUnit.assertEquals(posts.size(),10);
		
	}
	@Test
	@DataProvider(name="userID")
	public Object[][]getuserDataProvider(){
		return new Object[][]{{1,2},{3,4}};
		
		
	}
	@Test
	public static void testPostObjectPOSTResponse() {
		
		String postRequestBody = "{\r\n"
				+ "    \"userId\":7,\r\n"
				+ "    \"title\": \"Sample for the rest ASSURED\",\r\n"
				+ "    \"body\": \"Sample Request for REST ASSURED USING POSTMAN\"\r\n"
				+ "}";
			    		
			    		
		 given()
		 .header("Content-type","application/json")
		 .and()
		 .body(postRequestBody)
		 .when()//Execute
		 .post("/posts")
		 .then()// verification
		 .statusCode(201)
		 .body("id", equalTo(101));
	}
	
	
@Test
public static void testPostObjectPUTResponse() {
		
		String postRequestBody = "{\r\n"
				+ "    \"userId\":7,\r\n"
				+ "    \"title\": \"Sample for the rest ASSURED\",\r\n"
				+ "    \"body\": \"Sample Request for REST ASSURED USING POSTMAN\"\r\n"
				+ "}";
			    		
			    		
		 given()
		 .header("Content-type","application/json")
		 .and()
		 .body(postRequestBody)
		 .when()//Execute
		 .put("/posts/1")
		 .then()// verification
		 .statusCode(200);
//		 .body("id", equalTo(101));
	}





}
