package com.Demo.REST;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;



public class GraphQL {
 
	@Test
	public void TestGraphQL(){
		
		//Query
		RestAssured.baseURI = "https://rahulshettyacademy.com/gq/graphql";
		given().log().all().header("Content-Type", "Application/json").body(Payload.QueryGraphQL())
		.when().post().then().log().all();
		
		//Mutation
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/gq/graphql";
		given().log().all().header("Content-Type", "Application/json").body(Payload.MutationGraphQL())
		.when().post().then().log().all();
	}
}
