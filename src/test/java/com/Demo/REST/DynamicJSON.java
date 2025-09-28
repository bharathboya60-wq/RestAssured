package com.Demo.REST;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DynamicJSON {
	
	//Pass dynamic values as variables from the body
	//Parameterize the data from DataProvider.
	
	@Test(dataProvider = "BookData")
	public static void AddBook(String ISBN, String Aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String Res = given().header("Content-Type", "application/json").body(Payload.AddBook(ISBN, Aisle)).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath Js = new JsonPath(Res);
		String MSG = Js.getString("Msg");
		System.out.println(MSG);
		Assert.assertEquals("successfully added", MSG );
		
	}
	
	//Read JSON data from File
	//Convert file data into bites ==> Bites data to the string as body accepts string as data.
	@Test
	public static void ReadStaticJSONFile() throws IOException{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Data = new String(Files.readAllBytes(Paths.get("C:\\Users\\BB2712\\Desktop\\JSONS\\Addplace.json")));
//		System.out.println();
//		System.out.println(Dat
		String Res  = given().queryParam("key", "qaclick1234")
				.header("Content-Type", "application/json")
				.body(Data)
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().asString();		
				// TODO Auto-generated method stub
				
				System.out.println(Res);
				JsonPath Js = new JsonPath(Res);
//				System.out.println(Js);
				String place = Js.getString("place_id");
//				
		
		
		
		
	}
	
	//Parameterize the API with the JSON data.
	
	@DataProvider(name = "BookData")
	public Object[][] BookData() {
		String[][] BK = {{"PP","03"}, {"MNM", "31"}, {"SR", "20"}};
		return BK;
	}
	
	

}


