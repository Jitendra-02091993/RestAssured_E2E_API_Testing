package getCourseDetails;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jsonPayload.globalVariable;
import utility.helperUtils;

public class GetAccessTokenFromAuthorizationServer extends helperUtils{

	@Test
	public void getAccessTokenFromAuthorizationServer() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String path = "/oauthapi/oauth2/resourceOwner/token";

		Response response = given()
				.basePath(path)
				.formParams("client_id", globalVariable.client_id)
				.formParams("client_secret", globalVariable.client_secret)
				.formParams("grant_type", globalVariable.grant_type)
				.formParams("scope", globalVariable.scope)
				.when().log().all()
				.post();
		
		String responseBody = response.asString();
		System.out.println("responseBody is: "+responseBody);
		
		response.then().assertThat().statusCode(200);
		JsonPath parse = rawToJSON(responseBody);
		globalVariable.access_Tocken = parse.get("access_token");
		System.out.println("access_Tocken is: "+globalVariable.access_Tocken);
	}
	
	@DataProvider(name = "accessToken")
	public Object[] access_Token() {
		return new Object [] {globalVariable.access_Tocken};
	}

}
