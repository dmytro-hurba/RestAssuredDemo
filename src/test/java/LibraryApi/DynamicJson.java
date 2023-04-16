package LibraryApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {
    @Test
    public void addBook(){
        RestAssured.baseURI  = "http://216.10.245.166";
        String response = given().log().all()
                .header("Content-type","application/json")
                .body(files.Payload.addBook("test","test"))
        .when().log().all()
                .post("/Library/Addbook.php")
        .then().log().all()
                .assertThat()
                .statusCode(200)
        .extract()
                .response()
                .asString();
        JsonPath js = new JsonPath(response);
        String id = js.getString("ID");
        System.out.println(id);
    }
}
