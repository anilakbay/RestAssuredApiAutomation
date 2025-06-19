import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetBookingByIdTests {

    @Test
    public void GetBookingByIdTest() {

        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/611");

        response
                .then()
                .statusCode(200);
                //.log().all();

        response.prettyPrint();

        String firstName = response.jsonPath().getJsonObject("firstname");
        String lastName = response.jsonPath().getJsonObject("lastname");
        Assertions.assertEquals("Josh", firstName);
        Assertions.assertEquals("Allen", lastName);





        // This test will be implemented in the next step
        // The test will retrieve a booking by its ID and verify the response
    }
}
