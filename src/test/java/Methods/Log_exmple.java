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
		.get("https://hero-one-app-uat.azurewebsites.net/api/cloudware_prod?ORG_ID=ONEAPP")
		.then()
		.log().all();
//		.log().body();
	//	.log().cookies();
//		.log().headers();
		
	}

}
