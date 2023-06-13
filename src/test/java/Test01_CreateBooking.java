import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class Test01_CreateBooking {
	@Test
	public void CreateBooking() {
		JSONObject request = new JSONObject();
		request.put("firstname", "Test");
        request.put("lastname", "Payconiq");
        request.put("totalprice", "677");
        request.put("depositpaid", "true");
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2023-06-03");
        bookingDates.put("checkout", "2023-07-05");
        request.put("bookingdates", bookingDates);
        request.put("additionalneeds", "Breakfast");
		
	System.out.println(request.toJSONString());
	
	given().
	log().all().
	baseUri("https://restful-booker.herokuapp.com/").
	basePath("booking").
		contentType(ContentType.JSON).
		//accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		post().
	then().
		assertThat().statusCode(200).
		body(JsonSchemaValidator
	    .matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
	}
	
}


