package Methods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class TestCookies {
//	@Test(priority = 0)
	public void cookie_test()
	{
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.cookie("AEC", "Ackid1RMUfTsOiJ8UAmOkPBUQr0olJG0ven72aGt_DF98rfj6bYzyee7zA")
		.log().all();
	}
	@Test(priority = 1)
	public void get_Cookie_Info()
	{
		Response res = given()
		.when()
		.get("https://www.google.com");
		System.out.println(res.getCookie("AEC"));
		Map<String, String> cookies_value = res.getCookies();
		System.out.println(cookies_value.keySet());
		for(Entry<String, String> val:cookies_value.entrySet()) 
		{
		System.out.println(val.getKey() +" = " +val.getValue());	
		}
		for(String k:cookies_value.keySet())
		{
			System.out.println(k +" : " + res.getCookie(k));
		}
		
		
	}
}
