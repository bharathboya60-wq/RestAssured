package com.Demo.REST;
//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;


public class Baisc {

	public static void main(String[] args) {
		System.out.println("TEam");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String Res  = given().log().all().queryParam("key", "qaclick1234")
		.header("Content-Type", "application/json")
		.body(Payload.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().asString();		
		// TODO Auto-generated method stub
		
		System.out.println(Res);
		JsonPath Js = new JsonPath(Res);
//		System.out.println(Js);
		String place = Js.getString("place_id");
//		System.out.println("Place Is"+place);
		
		String UpdatePlace = "Updated Using the Value from the RESTBABE";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+place+"\",\r\n"
				+ "\"address\":\""+UpdatePlace+"\",\r\n"
	
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		String RESP1 = given().queryParam("key", "qaclick123").queryParam("place_id", place)
		.when().get("/maps/api/place/get/json")
		.then().log().all().extract().response().asString();
		
		JsonPath Js2 = new JsonPath(RESP1);
		String OutputAdd = Js2.get("address")+"Bharath";
		System.out.println(OutputAdd);
		
		Assert.assertEquals(UpdatePlace, OutputAdd);

	}

}
