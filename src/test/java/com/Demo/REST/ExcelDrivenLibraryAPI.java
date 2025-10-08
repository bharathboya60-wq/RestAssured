package com.Demo.REST;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.util.*;
import org.testng.annotations.Test;

import Files.Payload;


public class ExcelDrivenLibraryAPI {
	
	@Test
	public static void Addbook()
//	public static void main(String[] args)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "BharathFrom Hash Map");
		map.put("isbn", "645");
		map.put("aisle", "ret");
		map.put("author", "Mr.Boya");
		
		String Res = given().header("Content-Type", "Application/json").body(map).when().post("/Library/Addbook.php")
		.then().extract().response().asString();
		
		System.out.println(Res);
		
		
	}

}
