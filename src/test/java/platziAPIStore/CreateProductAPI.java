package platziAPIStore;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jsonPayload.createProductPayload;
import jsonPayload.globalVariable;

public class CreateProductAPI {
	
	@Test
	public static void validateCreateProductAPI() {
		RestAssured.baseURI = "https://api.escuelajs.co/api/v1/products/";
		
		Response response = given().log().all()
		.header("Content-Type","application/json")
		.body(createProductPayload.createProduct())
		.when()
		.post(); // made post call to create products
		
		String responseBody = response.asString();
		System.out.println("response body is "+responseBody);
		//Validating response status code
		response.then().assertThat().statusCode(201);
		
		JsonPath parser = new JsonPath(responseBody);
		parser.get("title").equals("DMart");
		int id = parser.get("id");
		globalVariable.id = parser.get("id");
		
		System.out.println("id is"+id);
		
		int categoryIds = parser.get("category.id");
		System.out.println(categoryIds);
		
		//Validating schema
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("createProductSchema.json"));
		
//		DeleteProductAPI.deleteProduct(id);
	}
	
	@DataProvider(name="ID")
	public Object[] dataProvider(){
		return new Object[] {globalVariable.id};

}
}
