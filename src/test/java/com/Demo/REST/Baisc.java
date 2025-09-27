package com.Demo.REST;
//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import Files.Payload;
import io.restassured.RestAssured;


public class Baisc {

	public static void main(String[] args) {
		System.out.println("TEam");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(Payload.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);		
		// TODO Auto-generated method stub

	}

}
