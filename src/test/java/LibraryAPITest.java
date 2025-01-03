import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonPayload.Payload;
import utility.helperUtils;

public class LibraryAPITest {
	
	@Test(dataProvider = "BookData")
	public void validateCreateBookAPI(String isbn, String aisle) {
		RestAssured.baseURI= "http://216.10.245.166/";
		
		String createdBookResponse = given().log().all().header("Content-Type","application/json").
		body(Payload.addBookAPI(isbn , aisle)).
		when().post("Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		JsonPath json = helperUtils.rawToJSON(createdBookResponse);
		String msg = json.get("Msg");
		System.out.println(msg);
		helperUtils.assertActualExpected(msg, "successfully added");
	}
	
	/*
	 * Note json body can be fetched from external files as well
	 * we will use Files.readAllBytes(Paths.get(File path))method which will give only json content in byte
	 * so we can decode it to string by using new String(Files.readAllBytes(Paths.get(File path)))
	 */
	
	@DataProvider(name="BookData")
	public Object[][] dataProvider() {
		return new Object[][] {{Payload.createRandomString(),helperUtils.RandomNumber()},
			{Payload.createRandomString(),helperUtils.RandomNumber()},{Payload.createRandomString(),helperUtils.RandomNumber()}};
	}

}
