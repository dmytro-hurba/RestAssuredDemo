import files.Payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class BasicBodyFromFIle {


            public static void main(String[] args) {
                RestAssured.baseURI="https://rahulshettyacademy.com";
                given().log().all().
                        queryParam("key", "qaclick123").
                        header("Content-type","application/json").
                        body(Payload.addPayload())
                        // for reading json from file can be used .body(new String(Files.readAllBytes(Path.get(PC path)))
                        .when().post("/maps/api/place/add/json")
                        .then().log().all().assertThat().statusCode(200)
                        .body("scope",equalTo("APP"))
                        .header("server",containsString("Apache"));

            }
        }



