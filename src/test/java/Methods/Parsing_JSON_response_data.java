package Methods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Parsing_JSON_response_data {
//@Test	
public void get_JSON_data()
{
	Response res = 
			given()
			.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:3000/store");
	
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.header("Content-type"),"application/json; charset=utf-8");
	String info = res.jsonPath().getString("Book[3].Phone");
	System.out.println(info);

}
//@Test	
public void get_all_data()
{
	Response res = 
			given()
			.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:3000/store");
	JSONObject json = new JSONObject(res.asString());	
	for(int i=0;i<json.getJSONArray("Book").length();i++)
	{
	 String phone_no = json.getJSONArray("Book").getJSONObject(i).get("Phone").toString();
		System.out.println(phone_no);
	}
	
}

	
}
