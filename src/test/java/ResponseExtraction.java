import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ResponseExtraction {
    public static void main(String[] args) {

        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response =
                given().
                    queryParam("key", "qaclick123").
                    header("Content-type","application/json").
                    body(Payload.addPayload())
                .when()
                        .post("/maps/api/place/add/json")
                .then()
                        .assertThat().statusCode(200)
                        .body("scope",equalTo("APP"))
                        .header("server",containsString("Apache"))
                .extract()
                        .response().asString();
        JsonPath js = new JsonPath(response);
                  String place_id = js.get("place_id");

//
        String newAdress = "Kavkaz";
        given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"place_id\": \""+place_id+"\",\n" +
                        "    \"address\": \""+newAdress+"\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}")
                .when().
                put("/maps/api/place/update/json")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        String getPlaceResponse = given().log().all()
                .queryParam("key","qaclick123")
                .queryParam("place_id",place_id)

                .when().log().all().
                get("/maps/api/place/get/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("address",equalTo(newAdress))
                .extract().response().asString();
        JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
        String actualAdrress = js1.getString("address");
        Assert.assertEquals(actualAdrress,newAdress);








    }
}
