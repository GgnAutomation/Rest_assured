package Methods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
public class Post_Method_diff_way {
	//Post request body using HashMap
//	@Test
	public void post_using_hashmap()
	{
		HashMap  has = new LinkedHashMap();
		has.put("Name", "Rani");
		has.put("Location", "Bihar");
		has.put("Phone", "809786567");
		String course[]= {"physic" ,"Math" ,"chemistry"};
		has.put("Course", course);
		given()
		.contentType("application/json")
		.body(has)
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("Name", equalTo("Rani"))
		.body("Location",equalTo("Bihar"))
		.body("Phone",equalTo("809786567"))
		.body("Course[0]", equalTo("physic"))
		.body("Course[1]", equalTo("Math"))
		.body("Course[2]", equalTo("chemistry"))
//		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	//Post request body using org.json library
//	@Test(priority = 0)
	public void post_usin_json_liberary()
	{
		JSONObject data = new JSONObject();
		data.put("Name", "Rani");
		data.put("Location", "Bihar");
		data.put("Phone", "809786567");
		String course[]= {"physic" ,"Math" ,"chemistry"};
		data.put("Course", course);
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("Name", equalTo("Rani"))
		.body("Location",equalTo("Bihar"))
		.body("Phone",equalTo("809786567"))
		.body("Course[0]", equalTo("physic"))
		.body("Course[1]", equalTo("Math"))
		.body("Course[2]", equalTo("chemistry"))
//		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
			
	}
	//Post request body using pojo class
//	@Test
	public void post_usin_POJO_class()
	{
		Pojo_class data = new Pojo_class();
		data.setName("Rani");
		data.setLocation("Bihar");
		data.setPhone("809786567");
		String course[] = {"physic","Math" ,"chemistry"};
		data.setCourse(course);
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Rani"))
		.body("location",equalTo("Bihar"))
		.body("phone",equalTo("809786567"))
		.body("course[0]", equalTo("physic"))
		.body("course[1]", equalTo("Math"))
		.body("course[2]", equalTo("chemistry"))
//		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	//Post request body using External JSON file 
	@Test
	public void post_usin_External_json_file() throws FileNotFoundException
	{
		File f = new File(".\\body.json");
		FileReader fi = new FileReader(f);
		JSONTokener jt = new JSONTokener(fi);
		JSONObject data = new JSONObject(jt);
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("Name", equalTo("Rahul"))
		.body("Location",equalTo("Delhi"))
		.body("Phone",equalTo("9878679000"))
		.body("Course[0]", equalTo("CS"))
		.body("Course[1]", equalTo("Bio"))
		.body("Course[2]", equalTo("Math"))
//		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}

//	@Test(priority = 1)
	public void delete()
	{
		given()
		.when()
		.delete("http://localhost:3000/Students/6")
		.then()
		.statusCode(200)
		.log().all();
	}

}
