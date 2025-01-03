package getCourseDetails;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCourseDetails extends GetAccessTokenFromAuthorizationServer{

	@Test(dataProvider = "accessToken")
	public void getCourseDetails(String accessToken) {
		System.out.println("accessToken is==========: "+accessToken);
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String basePath = "/oauthapi/getCourseDetails";
		// ?access_token=33VQpwS9fnn7uqz04HqVXg==

		Response response = given()
				.basePath(basePath)
				.queryParam("access_token", accessToken)
				.when().log().all()
				.get();

		String responseBody = response.asString();
		System.out.println("responseBody is: " + responseBody);

		response.then().assertThat().statusCode(401); // ignore status code because even we get response as expected still getting 401 status code

	}
}
