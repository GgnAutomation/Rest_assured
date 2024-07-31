package Methods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class Get_method {
	int id;
	
	@Test(priority = 0)
	public void getmethod()
	{
		String res = given()
		.when()
		.get("https://hero-one-app-uat.azurewebsites.net/api/cloudware_prod?ORG_ID=ONEAPP")
		.then()
		.statusCode(200)	
		.log().all().extract().asString();
		System.out.println(res ="");
		
	}
		@Test(priority = 1)
	public void post_Method()
	{
		HashMap has = new LinkedHashMap();
		has.put("Employee name =", "Kunal Pnadey");
		has.put("Employee id =", "845678");
		has.put("desination =", "Sr. associate");
		id=given()
		.contentType("application/json")	
		.body(has)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
	}
	@Test(dependsOnMethods = "post_Method",priority = 2)
	public void put_Method()
	{
		HashMap has = new LinkedHashMap();
		has.put("Employee name =", "Kunal Chaudhari");
		has.put("Employee id =", "845670");
		has.put("desination =", "Sr. associate");
		given()
		.contentType("application/json")
		.body(has)
		.when()
		.put("https://reqres.in/api/users/")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority = 3)
	public void delet_Method()
	{
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}
}
