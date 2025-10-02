package com.Demo.REST;
import org.testng.annotations.Test;

import Pojo.OrderProductDetails;
import Pojo.PlaceOrder;
import Pojo.ProductAdded;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.*;

import static io.restassured.RestAssured.*;
//import 

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class EcommerceBB {

	@Test
	public void TestEcommerce() {
		
		String Res = given().header("Content-Type","Application/json")
				.body("{\r\n"
				+ "    \"userEmail\":\"Test@postman.com\",\r\n"
				+ "    \"userPassword\":\"Test@post1\"\r\n"
				+ "    }")
		.when().post("https://rahulshettyacademy.com/api/ecom/auth/login")
		.then().extract().response().asString();
		
		JsonPath JS = new JsonPath(Res);
		String Token = JS.getString("token");
		String UserId = JS.getString("userId");
		System.out.println(Token);
		System.out.println(UserId);
		
		RequestSpecification RqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api").addHeader("Authorization", Token).build();
		
		ProductAdded PAD = given().spec(RqSpec).multiPart("productImage", new File("C:\\Users\\BB2712\\Pictures\\Screenshots\\IPHOne screnshot.png"))
		.formParam("productName", "RestAssuredPostman")
		.formParam("productCategory", "Underwears")
		.formParam("productSubCategory", "Styles")
		.formParam("productPrice", "11111")
		.formParam("productFor", "Womens")
		.formParam("productAddedBy", UserId)
		.formParam("productDescription", "Added product from Script")
		.when().post("/ecom/product/add-product")
		.then().extract().as(ProductAdded.class);
		
		String ProductId = PAD.getProductId();
		
		
		OrderProductDetails OPD = new OrderProductDetails();
		OPD.setCountry("Greece");
		OPD.setProductOrderedId(ProductId);
		
		List<OrderProductDetails> LS = Arrays.asList(OPD);
		PlaceOrder PO = new PlaceOrder();
		PO.setOrders(LS);
//		PO.getOrders().get(0);
		
		
		String PlacedOrder = given().log().all().spec(RqSpec).body(PO).header("ConTent-Type", "application/json")
		.when().post("/ecom/order/create-order")
		.then().log().all().extract().response().asString();
		
		JsonPath JS1 = new JsonPath(PlacedOrder);
		String OrderId = JS1.getString("orders.get(0)");
		System.out.println("Ordered ID "+ OrderId);
		
		given().spec(RqSpec).queryParam("id", OrderId).header("ConTent-Type", "application/json")
		.when().get("/ecom/order/get-orders-details")
		.then().log().all();
		
		
		given().spec(RqSpec)
		.when().delete("/ecom/product/delete-product/"+ProductId)
		.then().assertThat().statusCode(200);
		
		
		given().spec(RqSpec).queryParam("id", ProductId).header("ConTent-Type", "application/json")
		.when().get("/ecom/order/get-orders-details")
		.then().assertThat().statusCode(400);
		
	}

}
