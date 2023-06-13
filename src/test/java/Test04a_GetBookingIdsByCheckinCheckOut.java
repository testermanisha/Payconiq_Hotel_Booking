import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Test04a_GetBookingIdsByCheckinCheckOut {
	
		@Test
		public void GetBookingIdsByCheckinCheckOut(){
			given().
			log().all().
			baseUri("https://restful-booker.herokuapp.com/").
		    basePath("booking?{checkin}&{checkout}").
		  	pathParam("checkin", "2021-06-24").
		  	pathParam("checkout", "2021-12-12").
			when().
			get("https://restful-booker.herokuapp.com/booking?checkin=2021-06-24&checkout=2021-12-12").
			then().
			statusCode(200).
			log().all();
			}

	}

