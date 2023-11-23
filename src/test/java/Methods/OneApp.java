package Methods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class OneApp {
@Test
public void oneApp_validate()
{
	Response res = given()
	.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:3000/oneapp");
	System.out.println(res.getBody().asString());
	JSONObject jo = new JSONObject(res.asString());
//	for(int i=0;i<jo.getJSONArray("item").length();i++)
//	{
//		String emp = jo.getJSONArray("item").getJSONObject(i).get("name").toString();
//		System.out.println(emp);
//	}
}
	
}
