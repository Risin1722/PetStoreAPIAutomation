package api.endpoint;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import api.payload.user;
import io.restassured.response.Response;

public class UserEndPoints 
{

	public static Response createUser(user payload)
	{
		
		Response response=given()
			.contentType("application/JSON")
			.accept("application/JSON")
			.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return response;
	}
	
	public static Response getUser(String userName, user payload)
	
	{
		
		Response response=given()
			.pathParam("username", userName)
		
		.when()
			.get(Routes.get_url);
		
				return response;
	}
	
	public static Response updateUser(String userName, user payload)
	{
		
		Response response=given()
			.contentType("application/JSON")
			.accept("application/JSON")
			.pathParam("username", userName)
			.body(payload)
			
			.when()
				.put(Routes.update_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		
		Response response=given()
			.pathParam("username", userName)
		.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	
}
