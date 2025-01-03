package platziAPIStore;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetProductAPI {
	String url = "https://api.escuelajs.co/api/v1/products";
	
	@Test
	public void getListOfAllProducts() {
		// Set the base URI for Rest Assured
        RestAssured.baseURI = url;

        // Make a GET request with query parameters
        Response response = given().log().all()
                .queryParam("limit", 12) // Set limit parameter
                .queryParam("offset", 1) // Set offset parameter
                .header("accept", "*/*") // Set accept header
                .when()
                .get(); // Perform GET request

     // Print the response body
        String responseBody = response.asString();
        System.out.println("Response Body: " + responseBody);

	}
	
	@Test
	public void getSingleProductDetails() {
		RestAssured.baseURI = url;
		
		Response response = given().log().all()
							.header("accept", "*/*")
							.basePath("/139")
							.when()
							.get();
		
		// Print the response body
        String responseBody = response.asString();
        System.out.println("Response Body: " + responseBody);
        
        //Validating status code
        response.then().assertThat().statusCode(200);
        //Validating object from response body
		JsonPath jsonParser = new JsonPath(responseBody);
		String title = jsonParser.get("title");
		System.out.println(title);
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(title, "Classic Red Pullover Hoodies", "Title is not matched");
//		System.out.println(" SoftAssert Validation is completed");
		Assert.assertEquals(title, "Classic Red Pullover Hoodie", "Title is not matched");
		System.out.println(" HardAssert Validation for title is matched");
//		softAssert.assertAll();
		// Validating GET Response body schema
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getProductSchema.json")); // Validate against the schemanull, null)
		
		
		
	}
	
}
