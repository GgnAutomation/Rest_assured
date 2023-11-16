package api.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_Endpoints;
import api.payload.User;
import io.restassured.response.Response;

public class User_test {
	
	Faker faker;
	User userpayload;
	public Logger log;
	@BeforeClass
	public void setup_data()
	{
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 12));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		log=LogManager.getLogger("Rest_assured");
	}
	@Test(priority = 0)
	public void test_Postuser()
	{
		log.info("-------------Send user data in given API------------------ ");
		Response response = User_Endpoints.create_user(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------created user info sucessfully------------------ ");
	}
	@Test(priority = 1)
	public void test_getUser()
	{
		log.info("-------------Retrive user info for reading only------------------ ");
		Response response = User_Endpoints.read_user(userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------Retrived successfully------------------ ");
		
	}
	@Test(priority = 2)
	public void test_updateUser()
	{
		log.info("-------------Updated user info------------------ ");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 12));
		Response response=User_Endpoints.update_user(this.userpayload.getUsername(), userpayload);
		response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------After Updated user info------------------ ");
		Response responseafterupdate=User_Endpoints.update_user(this.userpayload.getUsername(), userpayload);
		responseafterupdate.then().log().all();
	}
	
	@Test(priority = 3)
	public void test_deleteUser()
	{
		log.info("-------------Delete user info------------------ ");
		Response response=User_Endpoints.delete_user(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("-------------Delete user info successfully------------------ ");
	}

}
