package com.Demo.REST;
import org.testng.annotations.Test;

import java.util.List;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class TestOne {


	public class OAuth {
		
		@Test
		public void TestOAuth() {
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
			
			Assert.assertEquals(Js.getString("token_type"), "Bearer");
			
			String Details = given().queryParam("access_token", Token)
			.when().get("/oauthapi/getCourseDetails")
			.then().extract().asString();
			System.out.println(Details);
			
			
		}

	}


}
