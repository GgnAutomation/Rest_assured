package Methods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Path_and_Query_Parameter {
	@Test
	public void pata_and_query_parameter()
	{
		given()
		.pathParam("mypath", "users")
//		.queryParam("page",2)
		.queryParam("id", 11)
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.statusCode(200)
		.log().all();

		
	}

}
