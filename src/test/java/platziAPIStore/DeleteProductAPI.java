package platziAPIStore;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProductAPI extends CreateProductAPI{
	
	@Test (dependsOnMethods = {"validateCreateProductAPI"}, dataProvider = "ID")
	public static void deleteProduct(int id) {
		RestAssured.baseURI = "https://api.escuelajs.co/api/v1/products/"+id+"";
		
		Response response = given().log().all()
		.header("Content-type","application/json")
		.when()
		.delete();
		
		response.then()
		.assertThat().statusCode(200);
		System.out.println("Validated Delete API");
	}
}
