package api.test;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_Endpoints;
import api.payload.Payload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class User_test {
	public Logger log;

	@BeforeClass
	public void setup_data() {
		log = LogManager.getLogger("Rest_assured");
	}

//	@Test(priority = 0)
	public void get_Country_Code() {
		log.info("-------------get Country Code API------------------ ");
		Response response = User_Endpoints.create_user(Payload.getCountryCode());
		response.then().log().all();
		String res = response.body().asString();
		JsonPath js = new JsonPath(res);
		String value = js.getString("PWSESSIONRS[0].PWPROCESSRS.PWDATA.oa_getCountryCode.Row[0].countryCode");
		System.out.println(value);
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------created Country Code API------------------ ");
	}

//	@Test(priority = 1)
	public void Verify_DMS() {
		log.info("-------------Verify DMS------------------ ");
		Response response = User_Endpoints.create_user(Payload.Verify_dms());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------Verified successfully------------------ ");

	}

//	@Test(priority = 2)
	public void Send_OTP() {
		log.info("-------------Send OTP------------------ ");
		Response response = User_Endpoints.create_user(Payload.Send_otp());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------Verified Send OTP------------------ ");

	}

//	@Test(priority = 3)
	public void Verify_API() throws FileNotFoundException {
		log.info("-------------MB_GET_AUTHORIZED------------------ ");
		String body = Payload.get_APIList("C:\\Users\\Welcome\\git\\Rest_assured\\Test_Data\\GET_AUTHORIZED.json");
		Response response = User_Endpoints.Send_body(body);
		response.then().log().all();
		response.getBody();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------Verified MB_GET_AUTHORIZED------------------ ");

	}

	@Test(priority = 4)
	public void Verify_external_login_API() throws FileNotFoundException {
		log.info("-------------External_Login_API------------------ ");
		String body = Payload.get_APIList("/Users/user/git/Rest_assured/Test_Data/ExternalLogin.json");
		Response response = User_Endpoints.create_user(body);
		response.then().log().all();
		response.getBody();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------External Login API Verified------------------ ");
	}

}
