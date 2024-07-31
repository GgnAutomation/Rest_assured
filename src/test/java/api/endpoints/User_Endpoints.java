package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_Endpoints {
	public static Response create_user(String payload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.Base_url);
		
		return response;
	}
	public static Response Send_body(Object payload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.Base_url);
		
		return response;
	}
	public static Response read_user(String user_name)
	{
		Response response = given()
		.pathParam("username", user_name)
		.when()
		.get(Routes.Base_url);
		return response;
	}
public static Response update_user(String user_name , Payload payload)
{
	 Response response = given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", user_name)
	.body(payload)
	.when()
	.put(Routes.Base_url);
	 return response;
}
public static Response delete_user(String user_name)
{
	Response response=given()
	.pathParam("username", user_name)
	.when()
	.delete(Routes.Base_url);
	return response;
}

}
