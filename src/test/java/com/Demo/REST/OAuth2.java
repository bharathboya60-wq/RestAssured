package com.Demo.REST;
import static io.restassured.RestAssured.*;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class OAuth2 {
	public static void main(String[] args)
	{
		String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";



		String partialcode=url.split("code=")[1];

		String code=partialcode.split("&scope")[0];


		System.out.println(code);
		
		String AcessTokenResponse = given().queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("state", "verifyfjdss")
		.queryParam("redirect_url", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
		.when().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		System.out.println("Token Printed is");
		System.out.println(AcessTokenResponse);
		
//		JsonPath JS = new JsonPath(Res);
		
		JsonPath JS = new JsonPath(AcessTokenResponse);
		String AccessToken = JS.getString("access_token");
		
		String response = given().log().all().queryParam("access_token", AccessToken)
		.when().get("https://rahulshettyacademy.com/getCourse.php").then().log().all().extract().response().asString();
		
		System.out.println(response);
	}

}
