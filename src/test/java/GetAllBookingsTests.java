import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetAllBookingsTests {
    @Test
    public void GetAllBookingTest() {
        given().
        when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().log().all()
                .statusCode(200);
    }
    // This test will be implemented in the next step
}
