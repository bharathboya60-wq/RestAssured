package com.Demo.REST;

import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;
public class JIRA {
	
	@Test
	public void CreateBug() {
		
		//Create a bug
		RestAssured.baseURI = "https://bharathboya60.atlassian.net";
		String Response = given().header("Accept", "Application/json").header("Content-Type", "Application/json")
				.header("Authorization", "Basic YmhhcmF0aGJveWE2MEBnbWFpbC5jb206QVRBVFQzeEZmR0YwcWhGVHdHUzZPNmlMbWtWNlZHVFFKdFV1SkM2VmttcnI1RXVpSWl1bU16Q3o4aGFUT3lwbnUyWDNBWURYTGxqSzdpak1fNmg2bmZCZm1PRE16S1lpUXV6d1I1R0w1UDJtbTZMYTctNEUzZ2R0aXlJV2ZxWDFQd0QzQ0pZNjVldW1hS09IOVI4UlhZcnktajVWT085WHpqMV9fcTk5UksyOWIxVEh4eTNRRTBrPTgyMjk1QjlC")
				.body(Payload.CreateBug())
				.when().post("/rest/api/2/issue")
				.then().extract().response().asString();
		JsonPath Js = new JsonPath(Response);
//		System.out.println(Js.prettify());
		String Bug_id = Js.getString("id");
		System.out.println(Bug_id);
		
		//Add attachments
		
		given().header("X-Atlassian-Token", "no-check")
		.header("Authorization", "Basic YmhhcmF0aGJveWE2MEBnbWFpbC5jb206QVRBVFQzeEZmR0YwcWhGVHdHUzZPNmlMbWtWNlZHVFFKdFV1SkM2VmttcnI1RXVpSWl1bU16Q3o4aGFUT3lwbnUyWDNBWURYTGxqSzdpak1fNmg2bmZCZm1PRE16S1lpUXV6d1I1R0w1UDJtbTZMYTctNEUzZ2R0aXlJV2ZxWDFQd0QzQ0pZNjVldW1hS09IOVI4UlhZcnktajVWT085WHpqMV9fcTk5UksyOWIxVEh4eTNRRTBrPTgyMjk1QjlC")
		.multiPart("file", new File("C:\\Users\\BB2712\\Pictures\\Screenshots\\JIRA Attachment from Postman.png"))
		.when().post("rest/api/3/issue/"+Bug_id+"/attachments")
		.then().log().all().assertThat().statusCode(200);
	}

}
