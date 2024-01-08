package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_Endpoints {
	public static Response create_user(User payload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	public static Response read_user(String user_name)
	{
		Response response = given()
		.pathParam("username", user_name)
		.when()
		.get(Routes.common_url);
		return response;
	}
public static Response update_user(String user_name , User payload)
{
	 Response response = given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", user_name)
	.body(payload)
	.when()
	.put(Routes.common_url);
	 return response;
}
public static Response delete_user(String user_name)
{
	Response response=given()
	.pathParam("username", user_name)
	.when()
	.delete(Routes.common_url);
	return response;
}
public static Response read_user_from_oneapp()
{
	Response response = given()
//	.pathParam("username", user_name)
	.when()
	.get(Routes.Base_url);
	return response;
}

}
