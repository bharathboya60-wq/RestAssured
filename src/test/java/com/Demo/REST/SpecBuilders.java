package com.Demo.REST;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import Files.Payload;
import Pojo.AddPlace;
import Pojo.coordinates;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
  
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
	
RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick1234").setContentType(ContentType.JSON).build();

ResponseSpecification rsp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
RequestSpecification Req = given().spec(res).body(AP);
	
	Req.log().all().post("/maps/api/place/add/json")
	.then().log().all().spec(rsp).extract().asString();
	}
}
	
