import io.restassured.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutWitUsingPreviousSavedDate {
    public static void main(String[] args) {
        baseURI = "https://rahulshettyacademy.com";
        given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"place_id\": \"af447f30ccd2f42a0b9b477d1785090d\",\n" +
                        "    \"address\": \"29, stelmaha\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}")
                .when().
                put("/maps/api/place/update/json")
                .then()
                .assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

    }
}
