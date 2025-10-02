package com.Demo.REST;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import Files.Payload;
import Pojo.AddPlace;
import Pojo.coordinates;
import io.restassured.RestAssured;

public class Serilization {
  
	@Test
	public void implementSerilization() {
	AddPlace AP = new AddPlace();
	AP.setAccuracy("101");
	AP.setName("BharathFromREST2");
	AP.setPhone_number("1234567890");
	List<String> Ls = Arrays.asList("AB","BC","CD");
	AP.setTypes(Ls);
	AP.setWebsite("https://bharathREStAssured.com");
	coordinates Co = new coordinates();
	Co.setLat(22.27182);
	Co.setLng(20.123466);
	AP.setLocation(Co);
	
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	
	String Res  = given().log().all().queryParam("key", "qaclick1234")
	.header("Content-Type", "application/json")
	.body(AP)
	.when().post("/maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).extract().asString();	
	}
}
	
