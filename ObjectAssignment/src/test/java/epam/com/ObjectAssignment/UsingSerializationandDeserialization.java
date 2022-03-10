package epam.com.ObjectAssignment;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
//import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;

public class UsingSerializationandDeserialization {

	public static final ObjectMapper MAPPER = new ObjectMapper();

	@Test
	public static void main() throws JsonProcessingException {
		MemberDetails member = new MemberDetails();
		// setting the values
		member.setId(3);
		member.setAuthor("Books");
		member.setTitle("twoBooks");
		String url = "https://jsonplaceholder.typicode.com/posts";
		// Converting the object to json
		String json = MAPPER.writeValueAsString(member);
		Response res = RestAssured.given().header("Content-Type", "application/json").body(json).when().post(url)
				.andReturn();
		assertEquals(res.getStatusCode(), 201, "http req");
	}

	@Test
	public void getObject() {
		String url = "https://jsonplaceholder.typicode.com/3";
		MemberDetails mem = RestAssured.given().get(url).as(MemberDetails.class);
		System.out.println(mem.toString());

	}

}
