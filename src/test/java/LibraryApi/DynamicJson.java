package LibraryApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn,String aisle){
        RestAssured.baseURI  = "http://216.10.245.166";
        String response = given().log().all()
                .header("Content-type","application/json")
                .body(files.Payload.addBook(aisle,isbn))
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

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][]{{"test1", "123dsd"}, {"test2", "1234asdad"}, {"test3", "12345gfasdf"}};

}}
