import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test05_DeleteBooking {
	@Test
	public void DeleteBooking() {
		// Construct request
		given().
		log().
		all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("{basePath}/{bookingId}").
		pathParam("basePath", "booking").
		pathParam("bookingId", "838").
		header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
		// Hit request
		when().
			delete().
		// Validate response
		then().
			assertThat().statusCode(201).
			log().all();
		
	}
	

}
