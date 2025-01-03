import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonPayload.Payload;
import jsonPayload.globalVariable;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicTest {
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://petstore.swagger.io";
		
		//make get request for petID which is not there
		given().log().all()
		.header("accept", "application/json")
	    .header("Content-Type", "application/json").basePath("/v2/pet/"+globalVariable.randomNum+"")
	    .when().get()
	    .then().log().all()
	    .assertThat().statusCode(404).body("message", equalTo("Pet not found"));
		
		//then create a body with such ID
		given().log().all()
		.header("accept", "application/json")
	    .header("Content-Type", "application/json").basePath("/v2/pet")
	    .body(Payload.getPetPayload())
	    .post()
	    .then().assertThat().statusCode(200).body("name", equalTo(globalVariable.randomString));
		
		
		
		
//		// Perform the PUT request
//		given().log().all()
//		    .header("accept", "application/json")
//		    .header("Content-Type", "application/json").basePath("/v2/pet")
//		    .body(PetPayload.getPetPayload()) // Set the request body
//		.when()
//		    .put() // Send the PUT request
//		.then()
//		    .log().all() // Log the response
//		    .assertThat()
//		    .statusCode(200) // Assert that the status code is 200 OK
//		    .body("name", equalTo(globalVariable.randomString)); 
//		
//
//        String response = given()
//            .log().all()
//            .header("accept", "application/json")
//            .basePath("/v2/pet/19")
//        .when()
//            .get() // Changed from request().get() to get()
//        .then()
//            .log().all()
//            .assertThat()
//            .statusCode(200)
//            .body("name", equalTo(globalVariable.randomString)).extract().response().asString();
//        
//        System.out.println(response);
//        JsonPath jsonParser = new JsonPath(response);
//        System.out.println(jsonParser);
//        System.out.println(jsonParser.getString("name"));

	}}
		
