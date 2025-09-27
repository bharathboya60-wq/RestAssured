package com.Demo.REST;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJSONBB {
	public static void main(String[] args)
	{
		JsonPath ComJS = new JsonPath(Payload.ComplexJSON());
		System.out.println(ComJS);
		String Dash = ComJS.getString("dashboard");
	//	String Response = ComJS.prettify();
		System.out.println(ComJS.getInt("dashboard.purchaseAmount")+200);
		List<Map<String, Object>> courses = ComJS.getList("courses");
		System.out.println("Courses are:"+ courses);
		System.out.println("No of courses = "+courses.size());
		System.out.println("Purchase Amount = "+ComJS.getInt("dashboard.purchaseAmount"));
		System.out.println("TitleofFirstCourse = "+ComJS.getString("courses[0].title"));
		int Amount = 0;
		for(int i=0; i < courses.size(); i++)
		{
			if(courses.get(i).get("title").equals("RPA"))
			{
			System.out.println(courses.get(i).get("title") + " : " + courses.get(i).get("price"));
			System.out.println("No of Copies sold by RPA are "+ courses.get(i).get("copies"));
			Map m = courses.get(i);
			Amount =Amount + (int) m.get("copies") * (int) m.get("price");
			}
			else
			{
				System.out.println(courses.get(i).get("title") + " : " + courses.get(i).get("price"));
				Map m = courses.get(i);
				Amount =Amount + (int) m.get("copies") * (int) m.get("price");
	//			Map m = 
			}
		}
		System.out.println("Amount from calculation is :"+ Amount);
		if(ComJS.getInt("dashboard.purchaseAmount") == Amount)
		{
			System.out.println("Purchase amount is correct");
		}
		else
		{
			System.out.println("Purchase amount is not correct");
		}
		
		String Cor = ComJS.getString("courses");
		System.out.println(Cor);
		}
}
