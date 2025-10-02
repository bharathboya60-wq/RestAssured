package com.Demo.REST;

import static io.restassured.RestAssured.given;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import Pojo.Api;
import Pojo.GetCourses;
import Pojo.WebAutomation;
import Pojo.courses;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class Deserilization {
	@Test
	public void TestOAuth() {
		String[] WebCourses = {"Selenium Webdriver Java", "Cypress", "Protractor"};
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Res = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credential")
				.formParam("scope", "trust")
				.when().post("/oauthapi/oauth2/resourceOwner/token")
				.then().assertThat().statusCode(200).extract().asString();
		JsonPath Js = new JsonPath(Res);
		String Token = Js.getString("access_token");
		System.out.println(Token);
		
//		Assert.assertEquals(Js.getString("token_type"), "Bearer");
		
		GetCourses gc = given().queryParam("access_token", Token)
		.when().get("/oauthapi/getCourseDetails")
		.then().extract().as(GetCourses.class);
		
		System.out.println(gc.getInstructor());
		System.out.println(gc.getLinkedIn());
		List<Api> C = gc.getCourses().getApi();
		courses Cu = gc.getCourses();
		System.out.println(Cu);
		
		// Price of specific API course
		for(int i=0;i<C.size();i++)
		{
			if(C.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
			{
				System.out.println(C.get(i).getPrice());
			}
		}
		
		//Show all the course titles in the WebAutomation
		
		List<WebAutomation> WAC = gc.getCourses().getwebAutomation();
		ArrayList<String> ActualOutput = new ArrayList<String>();
		for(int i = 0 ; i<WAC.size();i++) {
//			Assert.assertEquals(WebCourses[i], WAC.get(i).getCourseTitle());
			ActualOutput.add(WAC.get(i).getCourseTitle());
			
		}
		List<String> ExpectedOutput = Arrays.asList(WebCourses);
		
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}

}
