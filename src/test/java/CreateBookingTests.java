import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests {
    @Test
    public void CreateBookingTest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", "Anıl");
        requestBody.put("lastname", "Akbay");
        requestBody.put("totalprice", 300);
        requestBody.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2025-07-06");
        bookingDates.put("checkout", "2025-07-08");

        requestBody.put("bookingdates", bookingDates);
        requestBody.put("additionalneeds", "Breakfast");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Anıl", response.jsonPath().getString("booking.firstname"));
        Assertions.assertEquals("2025-07-08", response.jsonPath().getString("booking.bookingdates.checkout"));
        Assertions.assertEquals(300, response.jsonPath().getInt("booking.totalprice"));
    }
}
