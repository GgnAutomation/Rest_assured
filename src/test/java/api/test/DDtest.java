package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.User_Endpoints;
import api.payload.Payload;
import api.utilities.Data_provider;
import io.restassured.response.Response;

public class DDtest {
	public Payload payload;
	@Test(priority = 0,dataProvider = "Data" ,dataProviderClass = Data_provider.class)
	public void post_test(String id, String username ,String fname , String lname, 
			String email,String pwd , String ph)
	{
		 payload = new Payload();
//		payload.setId(Integer.parseInt(id));
//		payload.setUsername(username);
//		payload.setFirstName(fname);
//		payload.setLastName(lname);
//		payload.setEmail(email);
//		payload.setPassword(pwd);
//		payload.setPhone(ph);
//		Response response = User_Endpoints.create_user(payload);
//		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 1 , dataProvider = "UserNames" , dataProviderClass = Data_provider.class)
	public void delete_data(String username)
	{
		Response response = User_Endpoints.delete_user(username);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
