package jsonPayload;

import java.util.Random;

public class Payload {
	public static String createRandomString() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7; // Specify the length of the random string

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return randomString;
	}
	
	
	public static String getPetPayload() {
	    return "{\n" +
	            "  \"id\": "+globalVariable.randomNum+",\n" +
	            "  \"category\": {\n" +
	            "    \"id\": 10,\n" +
	            "    \"name\": \"" + globalVariable.randomString + "\"\n" +
	            "  },\n" +
	            "  \"name\": \"" + globalVariable.randomString + "\",\n" +
	            "  \"photoUrls\": [\n" +
	            "    \"string\"\n" +
	            "  ],\n" +
	            "  \"tags\": [\n" +
	            "    {\n" +
	            "      \"id\": 6,\n" +
	            "      \"name\": \"" + globalVariable.randomString + "\"\n" + // Removed extra quote
	            "    }\n" +
	            "  ],\n" +
	            "  \"status\": \"Sold\"\n" +
	            "}";
	}
	
//	public static String addBookAPI(String id, String name) {
//		return "{\r\n"
//				+ "  \"name\": \""+globalVariable.randomString+"\",\r\n"
//				+ "  \"isbn\": \"bcd\",\r\n"
//				+ "  \"aisle\": \""+globalVariable.randomNum+"\",\r\n"
//				+ "  \"author\": \"John foe\"\r\n"
//				+ "}";
//	}
	
	public static String addBookAPI(String id, String name) {
		return "{\r\n"
				+ "  \"name\": \""+id+"\",\r\n"
				+ "  \"isbn\": \"bcd\",\r\n"
				+ "  \"aisle\": \""+name+"\",\r\n"
				+ "  \"author\": \"John foe\"\r\n"
				+ "}";
	}


}
