package Methods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Log_exmple {
	
	@Test
	public void log_practice()
	{
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then();
	//	.log().status();
//		.log().body();
	//	.log().cookies();
//		.log().headers();
		
	}

}
