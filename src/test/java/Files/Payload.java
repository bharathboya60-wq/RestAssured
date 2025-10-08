package Files;

public class Payload {
	
	public static String AddPlace(){
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Place Passed for restassured\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09 jhefbgwjhbfj\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	public static String ComplexJSON() {
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}\r\n";
				
}
	public static String AddBook(String Isbn, String Aisle ) {
		String Payload = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Bha\",\r\n"
				+ "\"isbn\":\""+Isbn+"\",\r\n"
				+ "\"aisle\":\""+Aisle+"\",\r\n"
				+ "\"author\":\"BOYA\"\r\n"
				+ "}";
		return Payload;
	}
	public static String CreateBug() {
		String Payload = "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"This is created from RestAssured Script and attached the SS\",\r\n"
				+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API from REST ASUURED\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}";
		return Payload;
	}
	
	public static String QueryGraphQL() {
		String Payload = "{\"query\":\"query {\\n  location(locationId: 24950){\\n    id\\n    name\\n  }\\n  character(characterId: 17983){\\n    id\\n    name\\n    type\\n    location {\\n      id\\n    }\\n  }\\n  episode(episodeId: 16785)\\n  {\\n    id\\n    name\\n    air_date\\n    episode\\n    created\\n  }\\n}\\n\",\"variables\":null}";
		return Payload;
	}
	
	public static String MutationGraphQL() {
		String Payload = "{\"query\":\"mutation {\\n  createLocation(location: {name: \\\"RestAssuredKondapur\\\", type: \\\"Aiswarya\\\", dimension: \\\"3040\\\"}) {\\n    id\\n  }\\n  createCharacter(character:{name:\\\"NaveMan\\\", \\n    type: \\\"AquaMan\\\",\\n  \\tstatus: \\\"Unbeatble\\\",\\n  \\tspecies: \\\"Village\\\",\\n  \\tgender:\\\"AlphaaMale\\\",\\n  \\timage:\\\"Cool\\\",\\n    originId: 1334,\\n  \\tlocationId: 24948})\\n  {\\n    id\\n  }\\n  createEpisode(episode: {name: \\\"Deadly Attack\\\", air_date: \\\"5_10_2025\\\", episode:\\\"FInal\\\"})\\n  {\\n    id\\n  }\\n}\\n\",\"variables\":null}";
		return Payload;
	}
	
	
}
