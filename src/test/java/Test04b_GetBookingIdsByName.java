import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
public class Test04b_GetBookingIdsByName {
		
			@Test
			public void GetBookingIdsByName(){
				given().
				log().all().
				baseUri("https://restful-booker.herokuapp.com/").
			    basePath("booking?{firstname}&{lastname}").
			  	pathParam("firstname", "John").
			  	pathParam("lastname", "Smith").
				when().
				get("https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith").
				then().
				statusCode(200).
				log().all();
				}

		}


