package com.Demo.REST;

import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;


@Test
public class ComplexJSON {

	public static void main(String[] args) {
		JsonPath Js = new JsonPath(Payload.ComplexJSON());
		
		//Print Size of the courses
		int CourseSize = Js.getInt("courses.size()");
//		System.out.println(CourseSize);
		
		//Print the purchase amount
		int PurchaseAmount = Js.getInt("dashboard.purchaseAmount");
		System.out.println(PurchaseAmount);
		
		//Print the title of first course
		String FirstCourse = Js.getString("courses[0].title");
		System.out.println(FirstCourse);
		
		//Get all the prices and titles of all courses
		for(int i = 0; i<CourseSize; i++)
		{
			String Title = Js.get("courses["+i+"].title");
			int Price = Js.getInt("courses["+i+"].price");
			System.out.println(Title+" "+Price);
		}
		
		//Print No of copies sold by RPA
		for(int i = 0; i<CourseSize; i++)
		{
			String Title = Js.get("courses["+i+"].title");
			if(Title.equalsIgnoreCase("RPA")) {
				System.out.println("Copies sold by RPA were " + Js.getInt("courses["+i+"].copies"));
				break;
			}
		}
		
		//Verify if sum is equals to Purchase amount.
		int Amount = 1;
		for(int i = 0; i<CourseSize; i++)
		{
			Amount = Amount + Js.getInt("courses["+i+"].copies") * Js.getInt("courses["+i+"].price");
			System.out.println(Amount);
			
		}
		Assert.assertEquals(PurchaseAmount, Amount );
		
	}
}
