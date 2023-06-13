import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Test03_PartialUpdateBooking {
	@Test
	public void PartialUpdateBooking() {
		JSONObject payload = new JSONObject();
		payload.put("firstname","Test");
		payload.put("lastname","Payconiq");
		
		System.out.println(payload);
		System.out.println(payload.toJSONString());
		
		given().
		log().all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("{basePath}/{bookingId}").
		pathParam("basePath", "booking").
		pathParam("bookingId", "2").
	    header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
		contentType("application/json").
		accept("application/json").	
		//header("cookie","token=abc123").
		body(payload.toJSONString()).
		when().
		patch().
		then().
		assertThat().statusCode(200).
		log().all();
			
	
	}
	public void GetBookingById(){
		given().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("{basePath}/{bookingId}").
		pathParam("basePath", "booking").
		pathParam("bookingId", "2").
		when().
		get().
		then().
		statusCode(200).
		log().all().
		header("Content-Type", "application/json; charset=utf-8").
		assertThat().body("firstname", equalTo("Test")).
		assertThat().body("lastname", equalTo("Payconiq"));
	}


}
