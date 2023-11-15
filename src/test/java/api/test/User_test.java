package api.test;

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
	}
	@Test(priority = 0)
	public void test_Postuser()
	{
		Response response = User_Endpoints.create_user(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 1)
	public void test_getUser()
	{
		Response response = User_Endpoints.read_user(userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 2)
	public void test_updateUser()
	{
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 12));
		Response response=User_Endpoints.update_user(this.userpayload.getUsername(), userpayload);
		response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		Response responseafterupdate=User_Endpoints.update_user(this.userpayload.getUsername(), userpayload);
		responseafterupdate.then().log().all();
	}
	
	@Test(priority = 3)
	public void test_deleteUser()
	{
		Response response=User_Endpoints.delete_user(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
