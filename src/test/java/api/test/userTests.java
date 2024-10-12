package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class userTests
{

			
		Faker faker;
		user userpayload;
		
		
		@BeforeClass
		
		public void setupData()
		
		{
			faker=new Faker();
			userpayload=new user();
			
			userpayload.setId(faker.number().hashCode());
			userpayload.setFirstName(faker.name().firstName());
			userpayload.setLastName(faker.name().lastName());
			userpayload.setEmail(faker.internet().safeEmailAddress());
			userpayload.setPhone(faker.phoneNumber().phoneNumber());
			userpayload.setUsername(faker.name().username());
			userpayload.setPassword(faker.internet().password());
		}
		
		@Test(priority=0)
		public void testUserCreate()
		{
			
			Response response=UserEndPoints.createUser(userpayload);
			response.then().log().all();
			response.then().statusCode(200);
		
	}
		
		@Test(priority=1)
		public void testGetUser()
		{
			Response response=UserEndPoints.getUser(this.userpayload.getUsername(), userpayload);
			response.then().log().all();
			response.then().statusCode(200);
			
		}
	
		@Test(priority=2)
		public void testUpdateUser()
		{
			userpayload.setId(faker.number().hashCode());
			userpayload.setFirstName(faker.name().firstName());
			userpayload.setLastName(faker.name().lastName());
			
			Response response=UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
			response.then().log().all();
			response.then().statusCode(200);
			
		}
		
		@Test(priority=3)
		public void testDeleteUser()
		{
			Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
			response.then().log().all();
			response.then().statusCode(200);
			
		}
}
