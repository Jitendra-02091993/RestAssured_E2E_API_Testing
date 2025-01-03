package utility;
import java.util.Random;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class helperUtils {
	
	public static JsonPath rawToJSON(String response) {
		JsonPath jsonParser = new JsonPath(response);
		return jsonParser;
	}
	
//	public static int RandomNumber() {
//        Random rand = new Random();
//        int randomNumber = rand.nextInt(900) + 10; // Generates a number between 10 and 99
//        System.out.println("Random Two-Digit Number: " + randomNumber);
//        return randomNumber;
//    }
	public static String RandomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(900) + 10; // Generates a number between 10 and 99
        System.out.println("Random Two-Digit Number: " + randomNumber);
        return String.valueOf(randomNumber);
    }
	
	public static void assertActualExpected(String actual , String expected) {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("Expected and Actual Text is matched");
		}catch(AssertionError e) {
			e.printStackTrace();
		}
		
	}
	

}
