import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().
                queryParam("key", "qaclick123").
                header("Content-type","application/json").
                body("{\n" +
                        "    \"location\": {\n" +
                        "        \"lat\": -38.383494,\n" +
                        "        \"lng\": 33.427362\n" +
                        "    },\n" +
                        "    \"accuracy\": 50,\n" +
                        "    \"name\": \"Test1\",\n" +
                        "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "    \"address\": \"29, side layout, cohen 09\",\n" +
                        "    \"types\": [\n" +
                        "        \"shoe park\",\n" +
                        "        \"shop\"\n" +
                        "    ],\n" +
                        "    \"website\": \"http://google.com\",\n" +
                        "    \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server",containsString("Apache"));
    }
}
