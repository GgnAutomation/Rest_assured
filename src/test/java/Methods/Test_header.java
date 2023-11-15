package Methods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Test_header {
	@Test
	public void test_Header()
	{
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("Server", "gws")
		.log().headers();
	}
//	@Test
	public void get_Header()
	{
		Response res = given()
		.when()
		.get("https://www.google.com");
		System.out.println("The vale of Content-Type =" +res.getHeader("Content-Type"));
		Headers header_value = res.getHeaders();
		for(Header hd:header_value)
		{
		 System.out.println(hd.getName() + " = " +hd.getValue());
		}
	}

}
