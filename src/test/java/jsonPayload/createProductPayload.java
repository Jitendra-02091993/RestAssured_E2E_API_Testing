package jsonPayload;

public class createProductPayload {
	
	public static String createProduct() {
		return "{\r\n"
				+ "  \"title\": \"DMart\",\r\n"
				+ "  \"price\": 123,\r\n"
				+ "  \"description\": \"Flexible price\",\r\n"
				+ "  \"categoryId\": 6,\r\n"
				+ "  \"images\": [\"https://placeimg.com/640/480/any\"]\r\n"
				+ "}";
	}

}
