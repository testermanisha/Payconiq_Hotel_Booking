import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test02_GetBookingById {
	@Test
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
		assertThat().body("firstname", equalTo("Susan")).
		assertThat().body("lastname", equalTo("Brown")).
		assertThat().body("totalprice", equalTo(241)).
		assertThat().body("depositpaid", equalTo(false)).
		assertThat().body("bookingdates.checkin", equalTo("2018-01-17")).
		assertThat().body("bookingdates.checkout", equalTo("2018-04-30"));
	}

}
