import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test04_GetBookingIds {
	@Test
public void GetBookingIds(){
		given().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		when().
		get().
		then().
		statusCode(200).
		log().all();
		}
	}

